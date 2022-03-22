package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Customer;
import model.Model;
import model.Product;
import view.View;

public class Controller {
	private final String FILE_NAME = "products.txt";
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		view.setOrderScene();

		EventHandler<ActionEvent> EventHandlerToSubmitOrder = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if ((!view.getRbAscending()) && (!view.getRbDescending()) && (!view.getRbInsert())) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("*** You Need To Choose Order First ***");
					alert.show();

				} else {
					if (view.getRbAscending() && view.getBtSubmitOrder().isArmed()) {
						model.getStore().getStoreCommand().setMapSortCommand("Ascend");
						//// need to set store map type from the model
					}
					if (view.getRbDescending() && view.getBtSubmitOrder().isArmed()) {
						model.getStore().getStoreCommand().setMapSortCommand("Descend");
						//// need to set store map type from the model
					}
					if (view.getRbInsert() && view.getBtSubmitOrder().isArmed()) {
						model.getStore().getStoreCommand().setMapSortCommand("Insert");
						//// need to set store map type from the model
					}
					closeButtonActionSubmitOrder(); //// close the order scene
					view.setMainScene();
					if (model.getStore().getStoreCommand().readProductsFromFileCommand())
						view.fileUploadedAlert();
					else
						view.fileEmptyAlert();
				}
			}
		};

		view.EventHandlerToSubmitOrder(EventHandlerToSubmitOrder);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToInsertProduct = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) { /// need to check mistakes & need to save in file
				Customer c = new Customer();
				Product p = new Product();

				boolean add = true;
				if (!view.getRbTrueNotification().isSelected() && !view.getRbFalseNotification().isSelected())
					add = false;
				if (!c.setAllValues(view.getTfCustomerName(), view.getTfCustomerPhone(), view.getNotification()))
					add = false;
				if (!p.setAllValues(view.getTfProductName(), view.getTfProductPriceToStore(),
						view.getTfProductPriceToCustomer(), c))
					add = false;
				if (add == false) {
					view.clearInsertTf();
					closeButtonActionSubmitInsert(); //// close the insert scene
					view.operationFailed();
				} else {
					model.getStore().getStoreCommand().addProductCommand(view.getTfProductId(), p);
					view.setUndoBtDisable(false); /////// after one insert the undo button is working

					view.clearInsertTf();
					closeButtonActionSubmitInsert(); //// close the insert scene
					view.operationPerformedSuccessfully();
				}
			}
		};

		view.EventHandlerToInsertProduct(EventHandlerToInsertProduct);

		//		EventHandler<ActionEvent> EventHandlerToInsertProduct = new EventHandler<ActionEvent>() {
		//
		//			@Override
		//			public void handle(ActionEvent event) { /// need to check mistakes & need to save in file
		//				Customer c = null;
		//				try {
		//					if (!view.getRbTrueNotification().isSelected() && !view.getRbFalseNotification().isSelected()) {
		//						c = null;
		//					} else {
		//						c = new Customer(view.getTfCustomerName(), view.getTfCustomerPhone(), view.getNotification());
		//					}
		//				} catch (Exception e) {
		//					view.operationFailed();
		//				}
		//				Product p = null;
		//				try {
		//					p = new Product(view.getTfProductName(), view.getTfProductPriceToStore(),
		//							view.getTfProductPriceToCustomer(), c);
		//				} catch (Exception e) {
		//					view.operationFailed();
		//				}
		//				if ((p != null) && (c != null)) {
		//					try {
		//						model.getStore().getStoreCommand().addProductCommand(view.getTfProductId(), p);
		//						view.setUndoBtDisable(false); /////// after one insert the undo button is working
		//					} catch (Exception e) {
		//						view.operationFailed();
		//					}
		//					view.clearInsertTf();
		//					closeButtonActionSubmitInsert(); //// close the insert scene
		//					view.operationPerformedSuccessfully();
		//				} else {
		//					view.clearInsertTf();
		//					closeButtonActionSubmitInsert(); //// close the insert scene
		//					view.operationFailed();
		//				}
		//
		//			}
		//		};
		//
		//		view.EventHandlerToInsertProduct(EventHandlerToInsertProduct);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToRemoveProductById = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) { /// need to check mistakes & need to save in file

				if (model.getStore().getStoreCommand().removeProductByIdCommand(view.getTfIdRemove()))
					view.operationPerformedSuccessfully();
				else
					view.operationFailed();
				// view.areYouSureAlert(); //// yes or no need to fix
				view.clearRemoveByIdTf();
				closeButtonActionRemove(); ///// close remove scene
			}
		};
		view.EventHandlerToRemoveProductById(EventHandlerToRemoveProductById);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToRemoveAllProductButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) { /// need to check mistakes & need to save in file
				// view.areYouSureAlert(); /// if yes so do it
				if (model.getStore().getStoreCommand().removeAllProductsCommand())
					view.operationPerformedSuccessfully();
				else
					view.fileEmptyAlert();

			}
		};

		view.EventHandlerToRemoveAllProductButtonInMain(EventHandlerToRemoveAllProductButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToRemoveButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.setRemoveByIdScene();
			}
		};

		view.EventHandlerToRemoveButtonInMain(EventHandlerToRemoveButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToInsertButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.setInsertScene();
			}
		};

		view.EventHandlerToInsertButtonInMain(EventHandlerToInsertButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToExitButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				closeButtonActionExit(); //// close the main scene
			}
		};

		view.EventHandlerToExitButtonInMain(EventHandlerToExitButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToShowAllButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (model.getStore().getStoreCommand().readProductsFromFileCommand()) {
					view.showProduct(model.getStore().getStoreCommand().showProductsCommand()); //// i add
					view.setShowAllScene();
					view.operationPerformedSuccessfully();
				} else
					view.fileEmptyAlert();
			}
		};

		view.EventHandlerToShowAllButtonInMain(EventHandlerToShowAllButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToUndoButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (model.getStore().getStoreCommand().removeLastProductCommand())
					view.operationPerformedSuccessfully(); ///// need to fix that
				else
					view.fileEmptyAlert();
				// view.showProduct(model.getStore().getStoreCommand());

			}
		};

		view.EventHandlerToUndoButtonInMain(EventHandlerToUndoButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToShowByIdButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.showProductById(model.getStore().getStoreCommand().showProductsCommand());
				//// need to change the func to showProductById(),
				view.setPutIdToShow();
				view.clearShowByIdTf();
			}
		};

		view.EventHandlerToShowByIdButtonInMain(EventHandlerToShowByIdButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToPutIdToShowButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				closeButtonActionShow();
				view.setShowByIdScene();
				view.operationPerformedSuccessfully(); ///// need to fix that

			}
		};

		view.EventHandlerToPutIdToShowButtonInMain(EventHandlerToPutIdToShowButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToSendSaleButtonInMain = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.setSendSaleScene();
				view.clearMessageTf();

			}
		};

		view.EventHandlerToSendSaleButtonInMain(EventHandlerToSendSaleButtonInMain);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToSendMessage = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				closeButtonActionSend();
				if (model.getStore().getStoreCommand().readProductsFromFileCommand()) {
					model.getStore().getStoreCommand().sendSaleCommand(view.getTfMessage());
					Thread showCustomer = new Thread(() -> {
						try {
							String name = "";

							List<String> currentAccepted = new ArrayList<String>();
							while ((name = model.getStore().getStoreCommand().getCurrentAcceptedCommand()) != null) {
								currentAccepted.add(name);
								Platform.runLater(() -> {
									view.showCustomerNames(currentAccepted);
								});
								Thread.sleep(2000);
							}
						} catch (InterruptedException e) {
							view.operationFailed();
						}
					});

					view.setSendMessgaeScene();
					showCustomer.start();
					view.operationPerformedSuccessfully(); ///// need to fix that
				} else {
					view.fileEmptyAlert();
				}
			}
		};

		view.EventHandlerToSendMessage(EventHandlerToSendMessage);

		////////////////////////////////////////////////////////////////

		EventHandler<ActionEvent> EventHandlerToShowProfit = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				if (model.getStore().getStoreCommand().readProductsFromFileCommand()) {
					view.showProfit(model.getStore().getStoreCommand().getProfit()); //// i add
					view.setShowProfitScene();
					view.operationPerformedSuccessfully();
				} else
					view.fileEmptyAlert();
			}
		};

		view.EventHandlerToShowProfit(EventHandlerToShowProfit);

		////////////////////////////////////////////////////////////////

		
	}

	private void closeButtonActionExit() {
		Stage stage = (Stage) view.getBtExit().getScene().getWindow();
		stage.close();
	}

	private void closeButtonActionSubmitOrder() {
		Stage stage = (Stage) view.getBtSubmitOrder().getScene().getWindow();
		stage.close();
	}

	private void closeButtonActionSubmitInsert() {
		Stage stage = (Stage) view.getBtSubmitInsert().getScene().getWindow();
		stage.close();
	}

	private void closeButtonActionRemove() {
		Stage stage = (Stage) view.getBtRemoveById().getScene().getWindow();
		stage.close();
	}

	private void closeButtonActionShow() {
		Stage stage = (Stage) view.getBtShow().getScene().getWindow();
		stage.close();
	}

	private void closeButtonActionSend() {
		Stage stage = (Stage) view.getBtSend().getScene().getWindow();
		stage.close();
	}

}
