package view;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class View {
	private Group root;
	private Group rootRb;
	private Group rootInsert;
	private Group rootRemove;
	private Group rootShow;
	private Group rootShowById;
	private Group rootPutIdToShow;
	private Group rootSendSaleInMain;
	private Group rootSendMessage;
	private Group rootShowProfit;

	private Scene scene;
	private Scene sceneRb;
	private Scene sceneInsert;
	private Scene sceneRemove;
	private Scene sceneShow;
	private Scene sceneShowById;
	private Scene scenePutIdToShow;
	private Scene sceneSendSaleInMain;
	private Scene sceneSendMessage;
	private Scene sceneShowProfit;

	private VBox vb;
	private Text txt;

	private VBox vbData;
	private TextField data;

	private VBox vbDataShowById;
	private TextField dataByID;

	private VBox vbDataMessage;
	private TextField dataMessage;

	private VBox vbShowProfit;
	private TextField tfProfit;

	private VBox vbRB;
	private VBox vbText;
	private Text txtRb;
	private RadioButton rbAscending;
	private RadioButton rbDescending;
	private RadioButton rbInsert;
	private Button btSubmit;
	private ToggleGroup tg;

	private Button btUndo;
	private Button btRemove;
	private Button btRemoveAll;
	private Button btInsert;
	private Button btExit;
	private Button btShowAll;
	private Button btShowById;
	private Button btSendSale;
	private Button btShowProfit;

	private Text txtInsert;
	private VBox vbInsert;
	private Label lblProductId;
	private Label lblProductName;
	private Label lblProductPriceToStore;
	private Label lblProductPriceToCustomer;
	private Label lblCustomerName;
	private Label lblCustomerPhone;
	private Label lblNotification;
	private TextField tfProductId;
	private TextField tfProductName;
	private TextField tfProductPriceToStore;
	private TextField tfProductPriceToCustomer;
	private TextField tfCustomerName;
	private TextField tfCustomerPhone;
	private RadioButton rbTrue;
	private RadioButton rbFalse;
	private ToggleGroup tgInfo;
	private Button btSubmit2;

	private Text txtRemove;
	private VBox vbRemove;
	private Label lblId;
	private TextField tfId;
	private Button btRemove2;

	private Text txtShowId;
	private VBox vbShowId;
	private Label lblShowId;
	private TextField tfShowId;
	private Button btShowId;

	private Text txtSendSale;
	private VBox vbSendSale;
	private Label lblMessage;
	private TextField tfMessage;
	private Button btSend;

	public View(Stage stage) {
		/////////////////// Main Scene

		this.root = new Group();

		this.txt = new Text("Store");
		this.txt.setFill(Color.ROYALBLUE);
		this.txt.setStyle("-fx-font: 60 arial;");
		this.txt.setTextAlignment(TextAlignment.CENTER);

		this.vb = new VBox();
		this.vb.setPadding(new Insets(0, 0, 0, 180));
		this.vb.getChildren().addAll(txt);

		 //// Buttons

		this.btInsert = new Button("Add Product");
		this.btInsert.setMinSize(70, 50);
		this.btInsert.setLayoutX(205);
		this.btInsert.setLayoutY(80);

		this.btShowProfit = new Button("Show Profit");
		this.btShowProfit.setMinSize(70, 50);
		this.btShowProfit.setLayoutX(208);
		this.btShowProfit.setLayoutY(145);

		this.btShowById = new Button("Show Product By Id");
		this.btShowById.setMinSize(100, 70);
		this.btShowById.setLayoutX(185);
		this.btShowById.setLayoutY(210);

		this.btShowAll = new Button("Show All Products");
		this.btShowAll.setMinSize(100, 70);
		this.btShowAll.setLayoutX(188);
		this.btShowAll.setLayoutY(290);

		this.btRemove = new Button("Remove Product By Id");
		this.btRemove.setMinSize(100, 70);
		this.btRemove.setLayoutX(178);
		this.btRemove.setLayoutY(370);

		this.btRemoveAll = new Button("Remove All Product");
		this.btRemoveAll.setMinSize(100, 70);
		this.btRemoveAll.setLayoutX(183);
		this.btRemoveAll.setLayoutY(450);

		this.btSendSale = new Button("Send Sale");
		this.btSendSale.setMinSize(100, 70);
		this.btSendSale.setLayoutX(190);
		this.btSendSale.setLayoutY(530);

		this.btUndo = new Button("Undo");
		this.btUndo.setDisable(true); /////////// Disable Undo Button
		this.btUndo.setMinSize(70, 50);
		this.btUndo.setLayoutX(205);
		this.btUndo.setLayoutY(615);

		this.btExit = new Button("Exit ");
		this.btExit.setMinSize(70, 50);
		this.btExit.setLayoutX(205);
		this.btExit.setLayoutY(680);



		///// Buttons
		this.root.getChildren().addAll(vb, btUndo, btRemove, btRemoveAll, btInsert, btShowAll, btExit, btShowById,
				btSendSale,btShowProfit);
		this.scene = new Scene(root, 500, 800);

		/////////////////// Main Scene

		/////////////////// Show All Scene

		this.rootShow = new Group();

		vbData = new VBox();
		data = new TextField();
		data.setEditable(false);

		vbData.setSpacing(5);
		vbData.setPadding(new Insets(80, 0, 0, 75));
		vbData.setMinSize(700, 800);
		vbData.getChildren().add(data);

		this.rootShow.getChildren().add(vbData);
		this.sceneShow = new Scene(rootShow, 800, 600);

		/////////////////// Show All Scene


		/////////////////// Show Profit Scene

		this.rootShowProfit = new Group();

		vbShowProfit = new VBox();
		tfProfit = new TextField();
		tfProfit.setEditable(false);

		vbShowProfit.setSpacing(5);
		vbShowProfit.setPadding(new Insets(80, 0, 0, 75));
		vbShowProfit.setMinSize(700, 800);
		vbShowProfit.getChildren().add(tfProfit);

		this.rootShowProfit.getChildren().add(vbShowProfit);
		this.sceneShowProfit = new Scene(rootShowProfit, 800, 600);

		/////////////////// Show Profit Scene

		/////////////////// Show By Id Scene

		this.rootShowById = new Group();

		vbDataShowById = new VBox();
		dataByID = new TextField();
		dataByID.setEditable(false);

		vbDataShowById.setSpacing(5);
		vbDataShowById.setPadding(new Insets(80, 0, 0, 75));
		vbDataShowById.setMinSize(700, 800);
		vbDataShowById.getChildren().add(dataByID);

		this.rootShowById.getChildren().add(vbDataShowById);
		this.sceneShowById = new Scene(rootShowById, 800, 600);

		/////////////////// Show By Id Scene

		/////////////////// Order Scene

		this.rootRb = new Group();

		this.txtRb = new Text("please choose the order \nto store the ptoducts in file:");
		this.txtRb.setFill(Color.ROYALBLUE);
		this.txtRb.setStyle("-fx-font: 30 arial;");
		this.txtRb.setTextAlignment(TextAlignment.CENTER);

		this.vbText = new VBox();
		this.vbText.setMargin(txtRb, new Insets(0, 0, 0, 60));
		this.vbText.getChildren().add(txtRb);

		this.tg = new ToggleGroup();
		this.rbAscending = new RadioButton("Ascend");
		this.rbAscending.setToggleGroup(tg);
		this.rbDescending = new RadioButton("Descend");
		this.rbDescending.setToggleGroup(tg);
		this.rbInsert = new RadioButton("Insert");
		this.rbInsert.setToggleGroup(tg);

		this.vbRB = new VBox();
		this.btSubmit = new Button("Submit");
		VBox.setMargin(btSubmit, new Insets(40, 0, 100, 200));

		this.vbRB.getChildren().addAll(rbAscending, rbDescending, rbInsert, btSubmit);
		VBox.setMargin(rbAscending, new Insets(100, 0, 100, 200));
		VBox.setMargin(rbDescending, new Insets(-70, 0, 0, 200));
		VBox.setMargin(rbInsert, new Insets(25, 0, 0, 201));

		this.rootRb.getChildren().addAll(vbRB, vbText);
		this.sceneRb = new Scene(rootRb, 470, 300);

		/////////////////// Order Scene

		/////////////////// Insert Scene
		this.rootInsert = new Group();

		this.txtInsert = new Text("Insert Product");
		this.txtInsert.setFill(Color.ROYALBLUE);
		this.txtInsert.setStyle("-fx-font: 60 arial;");

		this.vbInsert = new VBox();
		this.vbInsert.setPadding(new Insets(0, 0, 0, 190));
		this.vbInsert.getChildren().addAll(txtInsert);

		this.lblProductId = new Label("Product Id: ");
		this.lblProductId.setStyle("-fx-font: 20 arial");
		this.lblProductId.setPadding(new Insets(100, 0, 0, 50));

		this.lblProductName = new Label("Product Name: ");
		this.lblProductName.setStyle("-fx-font: 20 arial");
		this.lblProductName.setPadding(new Insets(140, 0, 0, 50));

		this.lblProductPriceToStore = new Label("Product Price To The Store: ");
		this.lblProductPriceToStore.setStyle("-fx-font: 20 arial");
		this.lblProductPriceToStore.setPadding(new Insets(180, 0, 0, 50));

		this.lblProductPriceToCustomer = new Label("Product Price To The Customer: ");
		this.lblProductPriceToCustomer.setStyle("-fx-font: 20 arial");
		this.lblProductPriceToCustomer.setPadding(new Insets(220, 0, 0, 50));

		this.lblCustomerName = new Label("Customer Name: ");
		this.lblCustomerName.setStyle("-fx-font: 20 arial");
		this.lblCustomerName.setPadding(new Insets(260, 0, 0, 50));

		this.lblCustomerPhone = new Label("Customer Phone: ");
		this.lblCustomerPhone.setStyle("-fx-font: 20 arial");
		this.lblCustomerPhone.setPadding(new Insets(300, 0, 0, 50));

		this.lblNotification = new Label("Notification: ");
		this.lblNotification.setStyle("-fx-font: 20 arial");
		this.lblNotification.setPadding(new Insets(340, 0, 0, 50));

		this.tfProductId = new TextField();
		this.tfProductId.setLayoutX(170);
		this.tfProductId.setLayoutY(100);

		this.tfProductName = new TextField();
		this.tfProductName.setLayoutX(200);
		this.tfProductName.setLayoutY(140);

		this.tfProductPriceToStore = new TextField();
		this.tfProductPriceToStore.setLayoutX(310);
		this.tfProductPriceToStore.setLayoutY(180);

		this.tfProductPriceToCustomer = new TextField();
		this.tfProductPriceToCustomer.setLayoutX(350);
		this.tfProductPriceToCustomer.setLayoutY(220);

		this.tfCustomerName = new TextField();
		this.tfCustomerName.setLayoutX(220);
		this.tfCustomerName.setLayoutY(260);

		this.tfCustomerPhone = new TextField();
		this.tfCustomerPhone.setLayoutX(225);
		this.tfCustomerPhone.setLayoutY(300);

		this.tgInfo = new ToggleGroup();
		this.rbTrue = new RadioButton("True");
		this.rbTrue.setToggleGroup(tgInfo);
		this.rbFalse = new RadioButton("False");
		this.rbFalse.setToggleGroup(tgInfo);

		this.rbTrue.setLayoutX(185);
		this.rbTrue.setLayoutY(345);

		this.rbFalse.setLayoutX(250);
		this.rbFalse.setLayoutY(345);

		this.btSubmit2 = new Button("Submit");
		this.btSubmit2.setMinSize(80, 50);
		this.btSubmit2.setLayoutX(300);
		this.btSubmit2.setLayoutY(400);

		this.rootInsert.getChildren().addAll(vbInsert, lblProductId, lblProductName, lblProductPriceToStore,
				lblProductPriceToCustomer, lblCustomerName, lblCustomerPhone, lblNotification, tfProductId,
				tfProductName, tfProductPriceToStore, tfProductPriceToCustomer, tfCustomerName, tfCustomerPhone, rbTrue,
				rbFalse, btSubmit2);
		this.sceneInsert = new Scene(rootInsert, 700, 500);
		/////////////////// Insert Scene

		/////////////////// Remove Scene

		this.rootRemove = new Group();

		this.txtRemove = new Text("Remove Product");
		this.txtRemove.setFill(Color.ROYALBLUE);
		this.txtRemove.setStyle("-fx-font: 40 arial;");

		this.vbRemove = new VBox();
		this.vbRemove.setPadding(new Insets(0, 0, 0, 55));
		this.vbRemove.getChildren().addAll(txtRemove);

		this.lblId = new Label("Id");
		this.lblId.setStyle("-fx-font: 25 arial");
		this.lblId.setPadding(new Insets(100, 0, 0, 100));

		this.tfId = new TextField();
		this.tfId.setLayoutX(150);
		this.tfId.setLayoutY(102);

		this.btRemove2 = new Button("Remove");
		this.btRemove2.setMinSize(60, 40);
		this.btRemove2.setLayoutX(170);
		this.btRemove2.setLayoutY(180);

		this.rootRemove.getChildren().addAll(vbRemove, lblId, tfId, btRemove2);
		this.sceneRemove = new Scene(rootRemove, 400, 300);
		/////////////////// Remove Scene

		/////////////////// Put Id To Show Scene

		this.rootPutIdToShow = new Group();

		this.txtShowId = new Text("Select Id To Show");
		this.txtShowId.setFill(Color.ROYALBLUE);
		this.txtShowId.setStyle("-fx-font: 40 arial;");

		this.vbShowId = new VBox();
		this.vbShowId.setPadding(new Insets(0, 0, 0, 55));
		this.vbShowId.getChildren().addAll(txtShowId);

		this.lblShowId = new Label("Id");
		this.lblShowId.setStyle("-fx-font: 25 arial");
		this.lblShowId.setPadding(new Insets(100, 0, 0, 100));

		this.tfShowId = new TextField();
		this.tfShowId.setLayoutX(150);
		this.tfShowId.setLayoutY(102);

		this.btShowId = new Button("Show");
		this.btShowId.setMinSize(60, 40);
		this.btShowId.setLayoutX(170);
		this.btShowId.setLayoutY(180);

		this.rootPutIdToShow.getChildren().addAll(vbShowId, lblShowId, tfShowId, btShowId);
		this.scenePutIdToShow = new Scene(rootPutIdToShow, 400, 300);

		/////////////////// Put Id To Show Scene

		/////////////////// Send Message Scene

		this.rootSendMessage = new Group();

		vbDataMessage = new VBox();
		//		dataMessage = new TextField();
		//		dataMessage.setEditable(false);

		vbDataMessage.setSpacing(5);
		vbDataMessage.setPadding(new Insets(80, 0, 0, 75));
		vbDataMessage.setMinSize(700, 800);
		//		vbDataMessage.getChildren().add(dataMessage);

		this.rootSendMessage.getChildren().add(vbDataMessage);
		this.sceneSendMessage = new Scene(rootSendMessage, 800, 600);

		/////////////////// Send Message Scene

		/////////////////// Send Sale In Main Scene

		this.rootSendSaleInMain = new Group();

		this.txtSendSale = new Text("Send Sale To Customer");
		this.txtSendSale.setFill(Color.ROYALBLUE);
		this.txtSendSale.setStyle("-fx-font: 30 arial;");

		this.vbSendSale = new VBox();
		this.vbSendSale.setPadding(new Insets(0, 0, 0, 55));
		this.vbSendSale.getChildren().addAll(txtSendSale);

		this.lblMessage = new Label("Message:");
		this.lblMessage.setStyle("-fx-font: 25 arial");
		this.lblMessage.setPadding(new Insets(100, 0, 0, 30));

		this.tfMessage = new TextField();
		this.tfMessage.setLayoutX(150);
		this.tfMessage.setLayoutY(102);

		this.btSend = new Button("Send");
		this.btSend.setMinSize(60, 40);
		this.btSend.setLayoutX(170);
		this.btSend.setLayoutY(180);

		this.rootSendSaleInMain.getChildren().addAll(vbSendSale, lblMessage, tfMessage, btSend);
		this.sceneSendSaleInMain = new Scene(rootSendSaleInMain, 400, 300);
		/////////////////// Send Sale In Main Scene
	}

	public TextField getTfId() {
		return tfId;
	}

	public void setMainScene() {
		Stage stage = new Stage();
		stage.setTitle("Store");
		stage.setScene(this.scene);
		stage.show();
	}

	public void setOrderScene() {
		Stage stageRb = new Stage();
		stageRb.setTitle("Order Store");
		stageRb.setScene(this.sceneRb);
		stageRb.show();
	}

	public void setInsertScene() {
		Stage stageInsert = new Stage();
		stageInsert.setTitle("Insert Product");
		stageInsert.setScene(this.sceneInsert);
		stageInsert.show();
	}

	public void setRemoveByIdScene() {
		Stage stageRemoveById = new Stage();
		stageRemoveById.setTitle("Remove Product By Id");
		stageRemoveById.setScene(this.sceneRemove);
		stageRemoveById.show();
	}

	public void setShowAllScene() {
		Stage stageShowAll = new Stage();
		stageShowAll.setTitle("Show All Products");
		stageShowAll.setScene(this.sceneShow);
		stageShowAll.show();
	}

	public void setShowProfitScene() {
		Stage stageShowProfit = new Stage();
		stageShowProfit.setTitle("Show All Products");
		stageShowProfit.setScene(this.sceneShowProfit);
		stageShowProfit.show();
	}

	public void setShowByIdScene() {
		Stage stageShowById = new Stage();
		stageShowById.setTitle("Show Product By Id");
		stageShowById.setScene(this.sceneShowById);
		stageShowById.show();
	}

	public void setPutIdToShow() {
		Stage stagePutIdToShow = new Stage();
		stagePutIdToShow.setTitle("Select Id To Show");
		stagePutIdToShow.setScene(this.scenePutIdToShow);
		stagePutIdToShow.show();
	}

	public void setSendSaleScene() {
		Stage stageSendSale = new Stage();
		stageSendSale.setTitle("Send Sale To Customer");
		stageSendSale.setScene(this.sceneSendSaleInMain);
		stageSendSale.show();
	}

	public void setSendMessgaeScene() {
		Stage stageSendMessage = new Stage();
		stageSendMessage.setTitle("Send Sale To Customer");
		stageSendMessage.setScene(this.sceneSendMessage);
		stageSendMessage.show();
	}

	public void areYouSureAlert() {
		Alert areYSure = new Alert(AlertType.CONFIRMATION);
		areYSure.setContentText("Are you sure you want to proceed?");
		areYSure.getButtonTypes().set(0, new ButtonType("Yes"));
		areYSure.getButtonTypes().set(1, new ButtonType("No"));
		areYSure.show();
	}

	// public Boolean getAreYouSureAnswerAlert(Alert al) { ///////// i am trying to
	// get the answer from the alert
	// if (al.getResult().getText().equals("Yes")) {
	// return true;
	// }
	// return false;
	// }

	public void fileUploadedAlert() {
		Alert info = new Alert(AlertType.INFORMATION);
		;
		info.setContentText("The file \"products.txt\" has been uploaded");
		info.show();
	}

	public void fileEmptyAlert() {
		Alert info = new Alert(AlertType.INFORMATION);
		;
		info.setContentText("The file \"products.txt\" is empty or does not exist");
		info.show();
	}

	public void operationPerformedSuccessfully() {
		Alert success = new Alert(AlertType.INFORMATION);
		success.setContentText("The operation performed successfully");
		success.show();
	}



	public void operationFailed() {
		Alert failed = new Alert(AlertType.ERROR);
		;
		failed.setContentText("The operation Failed");
		failed.show();
	}

	public void idWasNotFoundAlert() {
		Alert failed = new Alert(AlertType.ERROR);
		;
		failed.setContentText("The id was not found , please try another one");
		failed.show();
	}

	public void clearInsertTf() {
		tfProductId.clear();
		tfProductName.clear();
		tfProductPriceToStore.clear();
		tfProductPriceToCustomer.clear();
		tfCustomerName.clear();
		tfCustomerPhone.clear();
		rbFalse.setSelected(false);
		rbTrue.setSelected(false);
	}

	public void clearRemoveByIdTf() {
		tfId.clear();
	}

	public void clearShowByIdTf() {
		tfShowId.clear();
	}

	public void clearMessageTf() {
		tfMessage.clear();
	}

	///// data

	public void removeData() {
		vbData.getChildren().clear();
	}

	public void removeDataById() {
		vbDataShowById.getChildren().clear();
	}

	public void removeDataMessage() {
		vbDataMessage.getChildren().clear();
	}

	public void removeProfit() {
		vbShowProfit.getChildren().clear();
	}

	public void showProduct(String map) { //// by string
		removeData();
		Text txt = new Text("Products");
		txt.setUnderline(true);
		txt.setFont(Font.font("segoe Print", 20));
		Text txt1 = new Text(map);

		ScrollPane sp = new ScrollPane(txt1);
		vbData.getChildren().addAll(txt, txt1, sp);

	}

	public void showProfit(String map) { //// by string
		removeProfit();
		Text txt = new Text("Profit");
		txt.setUnderline(true);
		txt.setFont(Font.font("segoe Print", 20));
		Text txt1 = new Text(map);

		ScrollPane sp = new ScrollPane(txt1);
		vbShowProfit.getChildren().addAll(txt, txt1, sp);

	}

	public void showProductById(String key) { /// by the key
		removeDataById();
		Text txt2 = new Text("Product");
		txt2.setUnderline(true);
		txt2.setFont(Font.font("segoe Print", 20));
		Text txt3 = new Text(key);

		vbDataShowById.getChildren().addAll(txt2, txt3);

	}

	public void showCustomerNames(List<String> key) { /// by Customer List?
		removeDataMessage();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < key.size(); i++) {
			str.append(key.get(i).toString() + "\n");
		}
		Label msg = new Label(getTfMessage());
		msg.setFont(Font.font("segoe Print", 40));
		Text txt4 = new Text("Customer List");
		txt4.setUnderline(true);
		txt4.setFont(Font.font("segoe Print", 20));
		Text txt5 = new Text(str.toString());
		txt5.setFont(Font.font("Tahoma", 20));

		vbDataMessage.getChildren().addAll(msg, txt4, txt5);

	}

	//	public void addCurrentAccepted(List) {
	//		
	//	}

	///// data

	//////// event handles

	public void EventHandlerToSubmitOrder(EventHandler<ActionEvent> event) {
		this.btSubmit.setOnAction(event);
	}

	public void EventHandlerToInsertProduct(EventHandler<ActionEvent> event) {
		this.btSubmit2.setOnAction(event);
	}

	public void EventHandlerToRemoveProductById(EventHandler<ActionEvent> event) {
		this.btRemove2.setOnAction(event);
	}

	public void EventHandlerToRemoveAllProductButtonInMain(EventHandler<ActionEvent> event) {
		this.btRemoveAll.setOnAction(event);
	}

	public void EventHandlerToRemoveButtonInMain(EventHandler<ActionEvent> event) {
		this.btRemove.setOnAction(event);
	}

	public void EventHandlerToInsertButtonInMain(EventHandler<ActionEvent> event) {
		this.btInsert.setOnAction(event);
	}

	public void EventHandlerToExitButtonInMain(EventHandler<ActionEvent> event) {
		this.btExit.setOnAction(event);
	}

	public void EventHandlerToShowAllButtonInMain(EventHandler<ActionEvent> event) {
		this.btShowAll.setOnAction(event);
	}

	public void EventHandlerToUndoButtonInMain(EventHandler<ActionEvent> event) {
		this.btUndo.setOnAction(event);
	}

	public void EventHandlerToShowByIdButtonInMain(EventHandler<ActionEvent> event) {
		this.btShowById.setOnAction(event);
	}

	public void EventHandlerToPutIdToShowButtonInMain(EventHandler<ActionEvent> event) {
		this.btShowId.setOnAction(event);
	}

	public void EventHandlerToSendSaleButtonInMain(EventHandler<ActionEvent> event) {
		this.btSendSale.setOnAction(event);
	}

	public void EventHandlerToSendMessage(EventHandler<ActionEvent> event) {
		this.btSend.setOnAction(event);
	}

	public void EventHandlerToShowProfit(EventHandler<ActionEvent> event) {
		this.btShowProfit.setOnAction(event);
	}

	//////// event handles

	//////// get
	public Button getBtSubmitOrder() {
		return this.btSubmit;
	}

	public boolean getRbAscending() {
		return rbAscending.isSelected();

	}

	public boolean getRbDescending() {
		return rbDescending.isSelected();

	}

	public boolean getRbInsert() {
		return rbInsert.isSelected();

	}

	public Button getBtSubmitInsert() {
		return this.btSubmit2;
	}

	public Button getBtRemoveById() {
		return this.btRemove2;
	}

	public Button getBtShow() {
		return this.btShowId;
	}

	public Button getBtSend() {
		return this.btSend;
	}

	public String getTfProductId() {
		return this.tfProductId.getText();
	}

	public String getTfProductName() {
		return this.tfProductName.getText();
	}

	public Integer getTfProductPriceToStore() {
		try {
			return Integer.valueOf(tfProductPriceToStore.getText());
		} catch (Exception e) {
			operationFailed();
			return -1;
		}
	}

	public Integer getTfProductPriceToCustomer() {
		try {
			return Integer.valueOf(tfProductPriceToCustomer.getText());
		} catch (Exception e) {
			operationFailed();
			return -1;
		}
	}

	public String getTfCustomerName() {
		return this.tfCustomerName.getText();
	}

	public String getTfCustomerPhone() {
		return this.tfCustomerPhone.getText();
	}

	public Boolean getNotification() {
		if (this.rbFalse.isSelected())
			return false;
		else
			return true;
	}

	public String getTfIdRemove() {
		return this.tfId.getText();
	}

	public Button getBtExit() {
		return this.btExit;
	}

	public String getTfMessage() {
		return this.tfMessage.getText();
	}

	public Scene getOrderScene() {
		return sceneRb;
	}

	public RadioButton getRbTrueNotification() {
		return rbTrue;
	}

	public RadioButton getRbFalseNotification() {
		return rbFalse;
	}

	//////// get

	/////// set

	public void setUndoBtDisable(Boolean bool) {
		this.btUndo.setDisable(bool);
	}

	/////// set
}
