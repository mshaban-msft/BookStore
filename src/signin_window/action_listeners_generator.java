package signin_window;

public class action_listeners_generator {
	
	/*
	
	//01_ATTRIBUTES
	//*************************************************************
	private ElementGenerator appElements;
	private BoardElementsGenerator boardElements;
	
	private int moveFromRow;
	private int moveFromCol;
	
	private int currentRow;
	private int currentCol;
	
	private ImageView selectedPiece;
	
	
	
	
	//02_CONSTRUCTOR
	//*************************************************************
	public ActionListenersGenerator(ElementGenerator appElements){
		this.appElements=appElements;
	}
	

	//03_INTERFACE METHODS
	//*************************************************************
	public void initialize(){
	
		
		updateDisplayedStatus();
		//buttons action listeners
		generateNewGameButtonActionListeners();
		generateLoadGameButtonActionListeners();
		generateSaveGameButtonActionListeners();
		generateMovePieceButtonActionListeners();
		generateUndoMoveButtonActionListeners();
		generateRedoMoveButtonActionListeners();
		
		//chess board action listeners
		generateChessBoardActionListeners();
		

		

	}	
	
	//***************************************************************************
	//***************************************************************************
	//04_CHESS BOARD ACTION LISTENERS
	//***************************************************************************
	//***************************************************************************
	
	private void generateChessBoardActionListeners(){
		boardElements=appElements.getChessBoard().getElements();
		//board cells action listeners
		for(Rectangle shape:boardElements.getWhiteBlocks()){
			generateBoardCellEvents(shape);
		}
		for(Rectangle shape:boardElements.getBlackBlocks()){
			generateBoardCellEvents(shape);
		}
		//board pieces action listeners
		for(ImageView row[]:boardElements.getBoardPieces()){
			for(ImageView piece:row){
				if(piece==null){continue;}
				generateBoardPieceEvents(piece);
			}
		}
	}
	
	//**************************************************
	private void generateBoardCellEvents(Rectangle cell){
		cell.setOnMouseEntered(e ->{
			Integer[] cellLocation=boardElements.getBoardCells().get(cell);
			currentRow=cellLocation[1];
			currentCol=cellLocation[0];
		});
		
		cell.setOnMouseClicked(e ->{
			if(selectedPiece!=null){
				boolean validMove=appElements.getGameEngine().movePiece(moveFromRow, moveFromCol, currentRow, currentCol);
				if(validMove==true){
					moveGuiPiece(moveFromRow, moveFromCol, currentRow, currentCol);
				}
			}
		});
	}
	
	//**************************************************
	private void generateBoardPieceEvents(ImageView piece){
		piece.setOnMouseClicked(e ->{
			if(selectedPiece==null){
				moveFromRow=currentRow;
				moveFromCol=currentCol;
				piece.setOpacity(0.5);
				selectedPiece=piece;
			}else if(selectedPiece.equals(piece)){
				selectedPiece.setOpacity(1);
				selectedPiece=null;
			}else if(selectedPiece!=null){
				boolean validMove=appElements.getGameEngine().movePiece(moveFromRow, moveFromCol, currentRow, currentCol);
				if(validMove==true){
					moveGuiPiece(moveFromRow, moveFromCol, currentRow, currentCol);
				}
			}
		});
	}
	
	//**************************************************
	private void moveGuiPiece(int fromRow, int fromCol, int toRow, int toCol){
		updateDisplayedStatus();
		//remove enemy from target cell if exists
		ImageView enemyPiece=boardElements.getBoardPieces()[toRow][toCol];
		boardElements.getInnerBoard().getChildren().remove(enemyPiece);
		//remove from current location
		ImageView piece=boardElements.getBoardPieces()[fromRow][fromCol];
		boardElements.getInnerBoard().getChildren().remove(piece);
		boardElements.getBoardPieces()[fromRow][fromCol]=null;
		//add to new location
		boardElements.getInnerBoard().add(piece, toCol, toRow);
		boardElements.getBoardPieces()[toRow][toCol]=piece;
		//other stuff
		piece.setOpacity(1);
		selectedPiece=null;
	}
	
	
	//***************************************************************************
	//***************************************************************************
	//04_BUTTON ACTION LISTENERS
	//***************************************************************************
	//***************************************************************************
	
	private void updateDisplayedStatus(){
		String gameStatus=appElements.getGameEngine().getGameStatus();
		appElements.getGameStatusDisplayLabel().setText(gameStatus);
		
		String playerTurn="Player Turn : "+appElements.getGameEngine().getPlayerTurn();
		appElements.getPlayerTurnLabel().setText(playerTurn);
	}
	
	
	//START NEW GAME BUTTON********************
	private void generateNewGameButtonActionListeners(){
		appElements.getNewGameButton().setOnMouseClicked(e ->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("New Image");
			alert.setHeaderText("Discard Progress & Start New Game?");
			alert.setContentText("Discard Progress?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				try{
					//game engine
					appElements.getGameEngine().startNewGame();
					//reset layout
					appElements.getChessBoard().resetGameBoard();
					//set action listeners
					for(ImageView row[]:boardElements.getBoardPieces()){
						for(ImageView piece:row){
							if(piece==null){continue;}
							generateBoardPieceEvents(piece);
						}
					}
				}catch (Exception ex){}
			} else {
			    // ... user chose CANCEL or closed the dialog
			}
		});
	}
	
	
	//LOAD GAME BUTTON*************************
	private void generateLoadGameButtonActionListeners(){
		appElements.getLoadGameButton().setOnMouseClicked(e ->{
			FileChooser fileChooser = new FileChooser();
			//set dialog configuration
				//title
				fileChooser.setTitle("Open Image");
				//default directory
				//String dir=System.getProperty("user.home");
				String dir="resources/saved_games/";
				fileChooser.setInitialDirectory(new File(dir));
				//restrict file types
				fileChooser.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter("bin", ".bin"),
						new FileChooser.ExtensionFilter("xml", ".xml")
				);

			//show dialog & use file
			File chosenFile=fileChooser.showOpenDialog(appElements.getLayout().getScene().getWindow());
			
			if(chosenFile!=null){
				if(getFileExtension(chosenFile).equalsIgnoreCase("bin")){
					//appEngine.loadImageXML(chosenFile.getPath());
					//renderImageFromEngine();
				}else{
					//appEngine.loadImageJSON(chosenFile.getPath());
					//renderImageFromEngine();
				}
			
	        }
			
		});
	}
	
	
	//SAVE NEW GAME BUTTON*********************
	private void generateSaveGameButtonActionListeners(){
		appElements.getSaveGameButton().setOnMouseClicked(e ->{
			FileChooser fileChooser = new FileChooser();
			//set dialog configuration
				//title
				fileChooser.setTitle("Save Image");
				//default directory
				//String directory=System.getProperty("user.home");
				String dir="resources/saved_games/";
				fileChooser.setInitialDirectory(new File(dir));
				//restrict file types
				fileChooser.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter("bin", ".bin"),
						new FileChooser.ExtensionFilter("xml", ".xml")
				);
			//show dialog & save file
			File chosenFile=fileChooser.showSaveDialog(appElements.getLayout().getScene().getWindow());
			if(chosenFile!=null){
				appElements.getGameEngine().saveGameProgress(chosenFile);
	        }
    	});
	}
	

	//MOVE PIECE BUTTON************************
	private void generateMovePieceButtonActionListeners(){
		appElements.getMovePieceButton().setOnMouseClicked(e ->{
			String fromCell=appElements.getMovePieceFrom().getText();
			String toCell=appElements.getMovePieceTo().getText();
			int[][] moveVector=obtainMoveVector(fromCell, toCell);
			//appElements.getBoardUI().applyMove(moveVector[0][0], moveVector[0][1], moveVector[1][0], moveVector[1][1]);
		});
	}
	
	
	//UNDO MOVE BUTTON*************************
	private void generateUndoMoveButtonActionListeners(){
		appElements.getUndoMoveButton().setOnMouseClicked(e ->{
			
			
		});
	}
	
	//REDO MOVE BUTTON*************************
	private void generateRedoMoveButtonActionListeners(){
		appElements.getUndoMoveButton().setOnMouseClicked(e ->{
			
			
		});
	}
	
	
	
	
	
	
	
	private int[][] obtainMoveVector(String fromCell, String toCell){
		int fromRow=Integer.parseInt(fromCell.substring(1))-1;
		int fromCol = fromCell.charAt(0) - 'a';
		
		int toRow=Integer.parseInt(toCell.substring(1))-1;
		int toCol=toCell.charAt(0) - 'a';
		
		int[][] result=new int[2][2];
		result[0][0]=fromRow; result[0][1]=fromCol;
		result[1][0]=toRow; result[1][1]=toCol;
		
		return result;
		
	}
	
	
	private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
	
	/*private void resetTextFields(){
		appElements.getAddNodeName().setText("node name");
		appElements.getAddPathFrom().setText("from");
		appElements.getAddPathTo().setText("to");
		appElements.getAddPathValue().setText("value");
		
		appElements.getCalculateTFInputNodeName().setText("in node");
		appElements.getCalculateTFOutputNodeName().setText("out node");
		
		appElements.getModifyEdgeValue().setText("value");
		
		
	}*/

	
	
}
