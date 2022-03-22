package View;

import Model.Participant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class View {
	private Group root;
	private Scene scene;
	private Scene tableScene;
	private Scene miniGame;
	private Group platform;
	private int numOfParticipantsInTheChampionship= 0;

	private VBox vb;
	private Text txt;
	private RadioButton rbTennis;
	private RadioButton rbBasketball;
	private RadioButton rbSoccer;
	private ToggleGroup tg;

	private Label lblParticipantName;
	private TextField tfParticipantName;

	private Button btnStart;
	private Button btnAddParticipant;


	private DropShadow dp;
	private TextField player1;
	private TextField player2;
	private TextField player3;
	private TextField player4;
	private TextField player5;
	private TextField player6;
	private TextField player7;
	private TextField player8;


	private VBox vbTable;
	private Text txtT;
	private VBox vbTFplayerT;

	private TextField player1T;
	private TextField player2T;
	private TextField player3T;
	private TextField player4T;
	private TextField player5T;
	private TextField player6T;
	private TextField player7T;
	private TextField player8T;

	public Button btnGame1;
	public Button btnGame2;
	public Button btnGame3;
	public Button btnGame4;
	public Button btnGame5;
	public Button btnGame6;
	public Button btnGame7;

	private TextField winner1;
	private TextField winner2;
	private TextField winner3;
	private TextField winner4;
	private TextField winner5;
	private TextField winner6;
	private TextField winner7;


	private Line line1;
	private Line line2;
	private Line line3;
	private Line line4;
	private Line line5;
	private Line line6;
	private Line line7;
	private Line line8;
	private Line line9;
	private Line line10;
	private Line line11;
	private Line line12;
	private Line line13;
	private Line line14;
	private Line line15;
	private Line line16;
	private Line line17;
	private Line line18;
	private Line line19;
	private Line line20;
	private Line line21;
	private Line line22;
	private Line line23;
	private Line line24;
	private Line line25;
	private Line line26;
	private Line line27;
	private Line line28;
	private Line line29;
	private Line line30;
	private Line line31;
	private Line line32;
	private Line line33;
	private Line line34;
	private Line line35;


	private Text txt1;
	private Text participant1;
	private Text participant2;
	public Button btnDone = new Button("Done");
	private TextField tf1P1;
	private TextField tf1P2;
	private TextField tf2P1;
	private TextField tf2P2;
	private TextField tf3P1;
	private TextField tf3P2;
	private TextField tf4P1;
	private TextField tf4P2;
	private TextField tf5P1;
	private TextField tf5P2;

	public View(Stage stage) {
		this.root = new Group();
		stage.setTitle("Championship");


		this.txt = new Text("Championship");
		txt.setFill(Color.ROYALBLUE);
		txt.setStyle("-fx-font: 60 arial;");
		txt.setTextAlignment(TextAlignment.CENTER);
		
		// radio buttons 
		this.tg = new ToggleGroup();
		this.rbTennis = new RadioButton("Tennis");
		rbTennis.setToggleGroup(tg);
		this.rbBasketball = new RadioButton("Basketball");
		rbBasketball.setToggleGroup(tg);
		this.rbSoccer = new RadioButton("Soccer");
		rbSoccer.setToggleGroup(tg);
		// radio buttons 



		VBox vbRB = new VBox();
		vbRB.getChildren().addAll(rbBasketball,rbSoccer,rbTennis);
		vbRB.setAlignment(Pos.CENTER_RIGHT);
		VBox.setMargin(rbTennis, new Insets(0,27,20,0));
		VBox.setMargin(rbBasketball, new Insets(0,5,20,0));
		VBox.setMargin(rbSoccer, new Insets(0,26,20,0));
		root.getChildren().add(vbRB);


		this.lblParticipantName = new Label("Participant Name:");
		this.tfParticipantName = new TextField();
		HBox hbName = new HBox();
		hbName.getChildren().addAll(lblParticipantName, tfParticipantName);
		hbName.setAlignment(Pos.CENTER);
		HBox.setMargin(lblParticipantName, new Insets(20,20,20,20));
		HBox.setMargin(tfParticipantName, new Insets(20,20,20,20));
		root.getChildren().add(hbName);


		this.btnAddParticipant = new Button("Add Participant");
		this.btnStart = new Button("Start Championship");
		HBox hbButton = new HBox();
		hbButton.getChildren().addAll(btnAddParticipant, btnStart);
		hbButton.setAlignment(Pos.CENTER);
		HBox.setMargin(btnAddParticipant, new Insets(20,20,20,20));
		HBox.setMargin(btnStart, new Insets(20,20,20,20));
		root.getChildren().addAll(hbButton);


		this.dp = new DropShadow();
		this.player1 = new TextField();
		this.player2 = new TextField();
		this.player3 = new TextField();
		this.player4 = new TextField();
		this.player5 = new TextField();
		this.player6 = new TextField();
		this.player7 = new TextField();
		this.player8 = new TextField();


		player1.setTranslateY(50);
		player1.setTranslateX(10);
		player1.setEffect(dp);
		player1.setMaxWidth(100);
		player1.setMinWidth(100);
		player1.setStyle("-fx-background-color: lightblue");

		player2.setTranslateY(70);
		player2.setTranslateX(10);
		player2.setEffect(dp);
		player2.setMaxWidth(100);
		player2.setMinWidth(100);
		player2.setStyle("-fx-background-color: lightblue");

		player3.setTranslateY(90);
		player3.setTranslateX(10);
		player3.setEffect(dp);
		player3.setMaxWidth(100);
		player3.setMinWidth(100);
		player3.setStyle("-fx-background-color: lightblue");

		player4.setTranslateY(110);
		player4.setTranslateX(10);
		player4.setEffect(dp);
		player4.setMaxWidth(100);
		player4.setMinWidth(100);
		player4.setStyle("-fx-background-color: lightblue");

		player5.setTranslateY(130);
		player5.setTranslateX(10);
		player5.setEffect(dp);
		player5.setMaxWidth(100);
		player5.setMinWidth(100);
		player5.setStyle("-fx-background-color: lightblue");

		player6.setTranslateY(150);
		player6.setTranslateX(10);
		player6.setEffect(dp);
		player6.setMaxWidth(100);
		player6.setMinWidth(100);
		player6.setStyle("-fx-background-color: lightblue");

		player7.setTranslateY(170);
		player7.setTranslateX(10);
		player7.setEffect(dp);
		player7.setMaxWidth(100);
		player7.setMinWidth(100);
		player7.setStyle("-fx-background-color: lightblue");

		player8.setTranslateY(190);
		player8.setTranslateX(10);
		player8.setEffect(dp);
		player8.setMaxWidth(100);
		player8.setMinWidth(100);
		player8.setStyle("-fx-background-color: lightblue");

		VBox vbTFplayer = new VBox();
		vbTFplayer.getChildren().addAll(player1,player2,player3,player4,player5,player6,player7,player8);
		vbTFplayer.setAlignment(Pos.CENTER_LEFT);
		root.getChildren().add(vbTFplayer);

		this.vb = new VBox();
		this.vb.getChildren().addAll(txt, vbTFplayer,vbRB, hbName, hbButton);
		this.vb.setAlignment(Pos.TOP_CENTER);

		this.scene = new Scene(vb,1000,700);


		///////////////////////////////////////////////////////////



		this.txtT = new Text("Championship");
		txtT.setFill(Color.ROYALBLUE);
		txtT.setStyle("-fx-font: 60 arial;");
		txtT.setTextAlignment(TextAlignment.CENTER);

		this.player1T = new TextField();
		this.player2T = new TextField();
		this.player3T = new TextField();
		this.player4T = new TextField();
		this.player5T = new TextField();
		this.player6T = new TextField();
		this.player7T = new TextField();
		this.player8T = new TextField();


		player1T.setTranslateY(50);
		player1T.setTranslateX(10);
		player1T.setEffect(dp);
		player1T.setMaxWidth(100);
		player1T.setMinWidth(100);
		player1T.setStyle("-fx-background-color: lightblue");

		player2T.setTranslateY(70);
		player2T.setTranslateX(10);
		player2T.setEffect(dp);
		player2T.setMaxWidth(100);
		player2T.setMinWidth(100);
		player2T.setStyle("-fx-background-color: lightblue");

		player3T.setTranslateY(90);
		player3T.setTranslateX(10);
		player3T.setEffect(dp);
		player3T.setMaxWidth(100);
		player3T.setMinWidth(100);
		player3T.setStyle("-fx-background-color: lightblue");

		player4T.setTranslateY(110);
		player4T.setTranslateX(10);
		player4T.setEffect(dp);
		player4T.setMaxWidth(100);
		player4T.setMinWidth(100);
		player4T.setStyle("-fx-background-color: lightblue");

		player5T.setTranslateY(130);
		player5T.setTranslateX(10);
		player5T.setEffect(dp);
		player5T.setMaxWidth(100);
		player5T.setMinWidth(100);
		player5T.setStyle("-fx-background-color: lightblue");

		player6T.setTranslateY(150);
		player6T.setTranslateX(10);
		player6T.setEffect(dp);
		player6T.setMaxWidth(100);
		player6T.setMinWidth(100);
		player6T.setStyle("-fx-background-color: lightblue");

		player7T.setTranslateY(170);
		player7T.setTranslateX(10);
		player7T.setEffect(dp);
		player7T.setMaxWidth(100);
		player7T.setMinWidth(100);
		player7T.setStyle("-fx-background-color: lightblue");

		player8T.setTranslateY(190);
		player8T.setTranslateX(10);
		player8T.setEffect(dp);
		player8T.setMaxWidth(100);
		player8T.setMinWidth(100);
		player8T.setStyle("-fx-background-color: lightblue");

		vbTFplayerT = new VBox();
		vbTFplayerT.getChildren().addAll(player1T,player2T,player3T,player4T,player5T,player6T,player7T,player8T);
		vbTFplayerT.setAlignment(Pos.CENTER_LEFT);
		root.getChildren().add(vbTFplayerT);


		this.btnGame1 = new Button("Play a game");
		this.btnGame2 = new Button("Play a game");
		this.btnGame3 = new Button("Play a game");
		this.btnGame4 = new Button("Play a game");
		VBox vbBtnGame1 = new VBox();
		vbBtnGame1.getChildren().addAll(btnGame1,btnGame2,btnGame3,btnGame4);
		vbBtnGame1.setTranslateX(200);
		vbBtnGame1.setTranslateY(-190);
		VBox.setMargin(btnGame1, new Insets(50,0,0,0));
		VBox.setMargin(btnGame2, new Insets(60,0,0,0));
		VBox.setMargin(btnGame3, new Insets(68,0,0,0));
		VBox.setMargin(btnGame4, new Insets(70,0,0,0));
		root.getChildren().add(vbBtnGame1);


		this.btnGame5 = new Button("Play a game");
		this.btnGame6 = new Button("Play a game");
		VBox vbBtnGame2 = new VBox();
		vbBtnGame2.getChildren().addAll(btnGame5,btnGame6);
		vbBtnGame2.setTranslateX(500);
		vbBtnGame2.setTranslateY(-500);
		VBox.setMargin(btnGame5, new Insets(50,0,0,0));
		VBox.setMargin(btnGame6, new Insets(150,0,0,0));
		root.getChildren().add(vbBtnGame2);


		this.btnGame7 = new Button("Play a game");							
		btnGame7.setMaxSize(110, 60);
		VBox vbBtnGame3 = new VBox();
		vbBtnGame3.getChildren().addAll(btnGame7);
		vbBtnGame3.setTranslateX(750);
		vbBtnGame3.setTranslateY(-670);
		VBox.setMargin(btnGame7, new Insets(50,0,0,0));
		root.getChildren().add(vbBtnGame3);


		this.winner1 = new TextField();
		this.winner2 = new TextField();
		this.winner3 = new TextField();
		this.winner4 = new TextField();
		VBox vbTfWinners1 = new VBox();
		vbTfWinners1.getChildren().addAll(winner1,winner2,winner3,winner4);
		vbTfWinners1.setTranslateX(-100);
		vbTfWinners1.setTranslateY(-877);
		vbTfWinners1.setMaxWidth(100);
		vbTfWinners1.setMinWidth(100);
		vbTfWinners1.setEffect(dp);
		VBox.setMargin(winner1, new Insets(50,0,0,0));
		VBox.setMargin(winner2, new Insets(60,0,0,0));
		VBox.setMargin(winner3, new Insets(68,0,0,0));
		VBox.setMargin(winner4, new Insets(70,0,0,0));
		root.getChildren().add(vbTfWinners1);


		this.winner5 = new TextField();
		this.winner6 = new TextField();
		VBox vbTfWinners2 = new VBox();
		vbTfWinners2.getChildren().addAll(winner5,winner6);
		vbTfWinners2.setTranslateX(200);
		vbTfWinners2.setTranslateY(-1150);
		vbTfWinners2.setMaxWidth(100);
		vbTfWinners2.setMinWidth(100);
		vbTfWinners2.setEffect(dp);
		VBox.setMargin(winner5, new Insets(15,0,0,0));
		VBox.setMargin(winner6, new Insets(148,0,0,0));
		root.getChildren().add(vbTfWinners2);


		this.winner7 = new TextField();

		VBox vbTfWinners3 = new VBox();
		vbTfWinners3.getChildren().add(winner7);
		vbTfWinners3.setTranslateX(420);
		vbTfWinners3.setTranslateY(-1285);
		vbTfWinners3.setMaxWidth(100);
		vbTfWinners3.setMinWidth(100);
		vbTfWinners3.setEffect(dp);
		VBox.setMargin(winner7, new Insets(15,0,0,0));
		root.getChildren().add(vbTfWinners3);



		//line

		line1 = new Line();
		line1.setStartX(126);
		line1.setStartY(138);
		line1.setEndX(240);
		line1.setEndY(138);

		line2 = new Line();
		line2.setStartX(126);
		line2.setStartY(188);
		line2.setEndX(240);
		line2.setEndY(188);

		line3 = new Line();
		line3.setStartX(126);
		line3.setStartY(238);
		line3.setEndX(240);
		line3.setEndY(238);

		line4 = new Line();
		line4.setStartX(126);
		line4.setStartY(288);
		line4.setEndX(240);
		line4.setEndY(288);

		line5 = new Line();
		line5.setStartX(126);
		line5.setStartY(338);
		line5.setEndX(240);
		line5.setEndY(338);

		line6 = new Line();
		line6.setStartX(126);
		line6.setStartY(388);
		line6.setEndX(240);
		line6.setEndY(388);

		line7 = new Line();
		line7.setStartX(126);
		line7.setStartY(438);
		line7.setEndX(240);
		line7.setEndY(438);

		line8 = new Line();
		line8.setStartX(126);
		line8.setStartY(488);
		line8.setEndX(240);
		line8.setEndY(488);

		line9 = new Line();
		line9.setStartX(240);
		line9.setStartY(138);
		line9.setEndX(240);
		line9.setEndY(150);

		line10 = new Line();
		line10.setStartX(240);
		line10.setStartY(188);
		line10.setEndX(240);
		line10.setEndY(177);

		line11 = new Line();
		line11.setStartX(240);
		line11.setStartY(238);
		line11.setEndX(240);
		line11.setEndY(250);

		line12 = new Line();
		line12.setStartX(240);
		line12.setStartY(290);
		line12.setEndX(240);
		line12.setEndY(277);

		line13 = new Line();
		line13.setStartX(240);
		line13.setStartY(338);
		line13.setEndX(240);
		line13.setEndY(348);

		line14 = new Line();
		line14.setStartX(240);
		line14.setStartY(388);
		line14.setEndX(240);
		line14.setEndY(377);

		line15 = new Line();
		line15.setStartX(240);
		line15.setStartY(438);
		line15.setEndX(240);
		line15.setEndY(450);

		line16 = new Line();
		line16.setStartX(240);
		line16.setStartY(488);
		line16.setEndX(240);
		line16.setEndY(480);

		line17 = new Line();
		line17.setStartX(292);
		line17.setStartY(163);
		line17.setEndX(340);
		line17.setEndY(163);

		line18 = new Line();
		line18.setStartX(292);
		line18.setStartY(263);
		line18.setEndX(340);
		line18.setEndY(263);

		line19 = new Line();
		line19.setStartX(292);
		line19.setStartY(363);
		line19.setEndX(340);
		line19.setEndY(363);

		line20 = new Line();
		line20.setStartX(292);
		line20.setStartY(463);
		line20.setEndX(340);
		line20.setEndY(463);

		line21 = new Line();
		line21.setStartX(401);
		line21.setStartY(163);
		line21.setEndX(458);
		line21.setEndY(163);

		line22 = new Line();
		line22.setStartX(401);
		line22.setStartY(263);
		line22.setEndX(458);
		line22.setEndY(263);

		line23 = new Line();
		line23.setStartX(401);
		line23.setStartY(363);
		line23.setEndX(458);
		line23.setEndY(363);

		line24 = new Line();
		line24.setStartX(401);
		line24.setStartY(463);
		line24.setEndX(458);
		line24.setEndY(463);

		line25 = new Line();
		line25.setStartX(458);
		line25.setStartY(163);
		line25.setEndX(458);
		line25.setEndY(200);

		line26 = new Line();
		line26.setStartX(458);
		line26.setStartY(260);
		line26.setEndX(458);
		line26.setEndY(232);

		line27 = new Line();
		line27.setStartX(458);
		line27.setStartY(363);
		line27.setEndX(458);
		line27.setEndY(390);

		line28 = new Line();
		line28.setStartX(458);
		line28.setStartY(463);
		line28.setEndX(458);
		line28.setEndY(427);

		line29 = new Line();
		line29.setStartX(512);
		line29.setStartY(213);
		line29.setEndX(565);
		line29.setEndY(213);

		line30 = new Line();
		line30.setStartX(512);
		line30.setStartY(413);
		line30.setEndX(565);
		line30.setEndY(413);

		line31 = new Line();
		line31.setStartX(626);
		line31.setStartY(213);
		line31.setEndX(670);
		line31.setEndY(213);

		line32 = new Line();
		line32.setStartX(626);
		line32.setStartY(413);
		line32.setEndX(670);
		line32.setEndY(413);

		line33 = new Line();
		line33.setStartX(710);
		line33.setStartY(213);
		line33.setEndX(710);
		line33.setEndY(283);

		line34= new Line();
		line34.setStartX(710);
		line34.setStartY(380);
		line34.setEndX(710);
		line34.setEndY(300);

		line35= new Line();
		line35.setStartX(762);
		line35.setStartY(314);
		line35.setEndX(786);
		line35.setEndY(314);


		VBox vbLine1 = new VBox();
		vbLine1.getChildren().addAll(line1,line2,line3,line4,line5,line6,line7,line8);
		vbLine1.setTranslateX(-365);
		vbLine1.setTranslateY(-1400);
		vbLine1.setMaxWidth(50);
		vbLine1.setMinWidth(50);
		VBox.setMargin(line1, new Insets(-55,0,0,0));
		VBox.setMargin(line2, new Insets(48,0,0,0));
		VBox.setMargin(line3, new Insets(40,0,0,0));
		VBox.setMargin(line4, new Insets(50,0,0,0));
		VBox.setMargin(line5, new Insets(40,0,0,0));
		VBox.setMargin(line6, new Insets(50,0,0,0));
		VBox.setMargin(line7, new Insets(45,0,0,0));
		VBox.setMargin(line8, new Insets(45,0,0,0));
		root.getChildren().add(vbLine1);


		VBox vbLine2 = new VBox();
		vbLine2.getChildren().addAll(line9,line10,line11,line12,line13,line14,line15,line16);
		vbLine2.setTranslateX(-250);
		vbLine2.setTranslateY(-1671);
		vbLine2.setMaxWidth(50);
		vbLine2.setMinWidth(50);
		VBox.setMargin(line9, new Insets(-55,0,0,0));
		VBox.setMargin(line10, new Insets(25,0,0,0));
		VBox.setMargin(line11, new Insets(40,0,0,0));
		VBox.setMargin(line12, new Insets(26,0,0,0));
		VBox.setMargin(line13, new Insets(40,0,0,0));
		VBox.setMargin(line14, new Insets(28,0,0,0));
		VBox.setMargin(line15, new Insets(45,0,0,0));
		VBox.setMargin(line16, new Insets(25,0,0,0));
		root.getChildren().add(vbLine2);


		VBox vbLine3 = new VBox();
		vbLine3.getChildren().addAll(line17,line18,line19,line20);
		vbLine3.setTranslateX(-180);
		vbLine3.setTranslateY(-1925);
		vbLine3.setMaxWidth(50);
		vbLine3.setMinWidth(50);
		VBox.setMargin(line17, new Insets(-55,0,0,0));
		VBox.setMargin(line18, new Insets(90,0,0,0));
		VBox.setMargin(line19, new Insets(95,0,0,0));
		VBox.setMargin(line20, new Insets(90,0,0,0));
		root.getChildren().add(vbLine3);


		VBox vbLine4 = new VBox();
		vbLine4.getChildren().addAll(line21,line22,line23,line24);
		vbLine4.setTranslateX(-20);
		vbLine4.setTranslateY(-2145);
		vbLine4.setMaxWidth(50);
		vbLine4.setMinWidth(50);
		VBox.setMargin(line21, new Insets(-55,0,0,0));
		VBox.setMargin(line22, new Insets(90,0,0,0));
		VBox.setMargin(line23, new Insets(95,0,0,0));
		VBox.setMargin(line24, new Insets(90,0,0,0));
		root.getChildren().add(vbLine4);


		VBox vbLine5 = new VBox();
		vbLine5.getChildren().addAll(line25,line26,line27,line28);
		vbLine5.setTranslateX(38);
		vbLine5.setTranslateY(-2369);
		vbLine5.setMaxWidth(50);
		vbLine5.setMinWidth(50);
		VBox.setMargin(line25, new Insets(-55,0,0,0));
		VBox.setMargin(line26, new Insets(25,0,0,0));
		VBox.setMargin(line27, new Insets(95,0,0,0));
		VBox.setMargin(line28, new Insets(27,0,0,0));
		root.getChildren().add(vbLine5);


		VBox vbLine6 = new VBox();
		vbLine6.getChildren().addAll(line29,line30);
		vbLine6.setTranslateX(117);
		vbLine6.setTranslateY(-2600);
		vbLine6.setMaxWidth(50);
		vbLine6.setMinWidth(50);
		VBox.setMargin(line29, new Insets(0,0,0,0));
		VBox.setMargin(line30, new Insets(180,0,0,0));
		root.getChildren().add(vbLine6);


		VBox vbLine7 = new VBox();
		vbLine7.getChildren().addAll(line31,line32);
		vbLine7.setTranslateX(277);
		vbLine7.setTranslateY(-2780);
		vbLine7.setMaxWidth(50);
		vbLine7.setMinWidth(50);
		VBox.setMargin(line31, new Insets(0,0,0,0));
		VBox.setMargin(line32, new Insets(175,0,0,0));
		root.getChildren().add(vbLine7);

		VBox vbLine8 = new VBox();
		vbLine8.getChildren().addAll(line33,line34);
		vbLine8.setTranslateX(321);
		vbLine8.setTranslateY(-2957);
		vbLine8.setMaxWidth(50);
		vbLine8.setMinWidth(50);
		VBox.setMargin(line33, new Insets(0,0,0,0));
		VBox.setMargin(line34, new Insets(25,0,0,0));
		root.getChildren().add(vbLine8);


		VBox vbLine9 = new VBox();
		vbLine9.getChildren().addAll(line35);
		vbLine9.setTranslateX(368);
		vbLine9.setTranslateY(-3050);
		vbLine9.setMaxWidth(50);
		vbLine9.setMinWidth(50);
		VBox.setMargin(line33, new Insets(0,0,0,0));
		root.getChildren().add(vbLine9);


		vbTable = new VBox();
		vbTable.getChildren().addAll(txtT,vbTFplayerT,vbBtnGame1,vbBtnGame2,
				vbBtnGame3,vbTfWinners1,vbTfWinners2,vbTfWinners3,vbLine1,vbLine2,vbLine3,vbLine4
				,vbLine5,vbLine6,vbLine7,vbLine8,vbLine9);
		vbTable.setAlignment(Pos.TOP_CENTER);

		this.tableScene = new Scene(vbTable,1000,700);

		stage.setScene(scene);
		stage.show();


	}

	public void vbGameTennis() {
		platform = new Group();

		txt1 = new Text("Tennis Game");
		txt1.setFill(Color.ROYALBLUE);
		txt1.setStyle("-fx-font: 30 arial;");
		txt1.setX(50);
		txt1.setY(40);

		participant1 = new Text();
		participant1.setStyle("-fx-font: 15 arial;");
		participant1.setX(10);
		participant1.setY(120);

		participant2 = new Text();
		participant2.setStyle("-fx-font: 15 arial;");
		participant2.setX(10);
		participant2.setY(190);


		btnDone.setLayoutX(135);
		btnDone.setLayoutY(270);


		tf1P1 = new TextField();
		tf1P1.setLayoutX(70);
		tf1P1.setLayoutY(105);
		tf1P1.setMaxWidth(35);

		tf2P1 = new TextField();
		tf2P1.setLayoutX(110);
		tf2P1.setLayoutY(105);
		tf2P1.setMaxWidth(35);

		tf3P1 = new TextField();
		tf3P1.setLayoutX(150);
		tf3P1.setLayoutY(105);
		tf3P1.setMaxWidth(35);

		tf4P1 = new TextField();
		tf4P1.setLayoutX(190);
		tf4P1.setLayoutY(105);
		tf4P1.setMaxWidth(35);

		tf5P1 = new TextField();
		tf5P1.setLayoutX(230);
		tf5P1.setLayoutY(105);
		tf5P1.setMaxWidth(35);

		tf1P2 = new TextField();
		tf1P2.setLayoutX(70);
		tf1P2.setLayoutY(175);
		tf1P2.setMaxWidth(35);

		tf2P2 = new TextField();
		tf2P2.setLayoutX(110);
		tf2P2.setLayoutY(175);
		tf2P2.setMaxWidth(35);

		tf3P2 = new TextField();
		tf3P2.setLayoutX(150);
		tf3P2.setLayoutY(175);
		tf3P2.setMaxWidth(35);

		tf4P2 = new TextField();
		tf4P2.setLayoutX(190);
		tf4P2.setLayoutY(175);
		tf4P2.setMaxWidth(35);

		tf5P2 = new TextField();
		tf5P2.setLayoutX(230);
		tf5P2.setLayoutY(175);
		tf5P2.setMaxWidth(35);

		platform.getChildren().addAll(txt1,participant1,participant2,
				btnDone,tf1P1,tf2P1,tf3P1,tf4P1,tf5P1,
				tf1P2,tf2P2,tf3P2,tf4P2,tf5P2);


		miniGame = new Scene(platform,300,300);


	}

	public void vbGameBasketball() {
		platform = new Group();

		txt1 = new Text("Basketball Game");
		txt1.setFill(Color.ROYALBLUE);
		txt1.setStyle("-fx-font: 30 arial;");
		txt1.setX(50);
		txt1.setY(40);

		participant1 = new Text();
		participant1.setStyle("-fx-font: 15 arial;");
		participant1.setX(10);
		participant1.setY(120);

		participant2 = new Text();
		participant2.setStyle("-fx-font: 15 arial;");
		participant2.setX(10);
		participant2.setY(190);


		btnDone.setLayoutX(135);
		btnDone.setLayoutY(270);


		tf1P1 = new TextField();
		tf1P1.setLayoutX(70);
		tf1P1.setLayoutY(105);
		tf1P1.setMaxWidth(35);

		tf2P1 = new TextField();
		tf2P1.setLayoutX(110);
		tf2P1.setLayoutY(105);
		tf2P1.setMaxWidth(35);

		tf3P1 = new TextField();
		tf3P1.setLayoutX(150);
		tf3P1.setLayoutY(105);
		tf3P1.setMaxWidth(35);

		tf4P1 = new TextField();
		tf4P1.setLayoutX(190);
		tf4P1.setLayoutY(105);
		tf4P1.setMaxWidth(35);

		tf1P2 = new TextField();
		tf1P2.setLayoutX(70);
		tf1P2.setLayoutY(175);
		tf1P2.setMaxWidth(35);

		tf2P2 = new TextField();
		tf2P2.setLayoutX(110);
		tf2P2.setLayoutY(175);
		tf2P2.setMaxWidth(35);

		tf3P2 = new TextField();
		tf3P2.setLayoutX(150);
		tf3P2.setLayoutY(175);
		tf3P2.setMaxWidth(35);

		tf4P2 = new TextField();
		tf4P2.setLayoutX(190);
		tf4P2.setLayoutY(175);
		tf4P2.setMaxWidth(35);

		platform.getChildren().addAll(txt1,participant1,participant2,
				btnDone,tf1P1,tf2P1,tf3P1,tf4P1,
				tf1P2,tf2P2,tf3P2,tf4P2);


		miniGame = new Scene(platform,300,300);


	}

	public void vbGameSoccer() {
		platform = new Group();

		txt1 = new Text("Soccer Game");
		txt1.setFill(Color.ROYALBLUE);
		txt1.setStyle("-fx-font: 30 arial;");
		txt1.setX(50);
		txt1.setY(40);

		participant1 = new Text();
		participant1.setStyle("-fx-font: 15 arial;");
		participant1.setX(10);
		participant1.setY(120);

		participant2 = new Text();
		participant2.setStyle("-fx-font: 15 arial;");
		participant2.setX(10);
		participant2.setY(190);


		btnDone.setLayoutX(135);
		btnDone.setLayoutY(270);


		tf1P1 = new TextField();
		tf1P1.setLayoutX(70);
		tf1P1.setLayoutY(105);
		tf1P1.setMaxWidth(35);

		tf2P1 = new TextField();
		tf2P1.setLayoutX(110);
		tf2P1.setLayoutY(105);
		tf2P1.setMaxWidth(35);

		tf3P1 = new TextField();
		tf3P1.setLayoutX(150);
		tf3P1.setLayoutY(105);
		tf3P1.setMaxWidth(35);

		tf4P1 = new TextField();
		tf4P1.setLayoutX(190);
		tf4P1.setLayoutY(105);
		tf4P1.setMaxWidth(35);

		tf1P2 = new TextField();
		tf1P2.setLayoutX(70);
		tf1P2.setLayoutY(175);
		tf1P2.setMaxWidth(35);

		tf2P2 = new TextField();
		tf2P2.setLayoutX(110);
		tf2P2.setLayoutY(175);
		tf2P2.setMaxWidth(35);

		tf3P2 = new TextField();
		tf3P2.setLayoutX(150);
		tf3P2.setLayoutY(175);
		tf3P2.setMaxWidth(35);

		tf4P2 = new TextField();
		tf4P2.setLayoutX(190);
		tf4P2.setLayoutY(175);
		tf4P2.setMaxWidth(35);

		platform.getChildren().addAll(txt1,participant1,participant2,
				btnDone,tf1P1,tf2P1,tf3P1,tf4P1,
				tf1P2,tf2P2,tf3P2,tf4P2);


		miniGame = new Scene(platform,300,300);


	}


	////event handles

	public void EventHandlerToAddParticipantButton(EventHandler<ActionEvent> event) {
		this.btnAddParticipant.setOnAction(event);
	}

	public void EventHandlerToStartChampionshipButton(EventHandler<ActionEvent> event) {
		this.btnStart.setOnAction(event);
	}

	public void EventHandlerToStartGame1(EventHandler<ActionEvent> event) {
		this.btnGame1.setOnAction(event);

	}

	public void EventHandlerToStartGame2(EventHandler<ActionEvent> event) {
		this.btnGame2.setOnAction(event);

	}
	public void EventHandlerToStartGame3(EventHandler<ActionEvent> event) {
		this.btnGame3.setOnAction(event);

	}
	public void EventHandlerToStartGame4(EventHandler<ActionEvent> event) {
		this.btnGame4.setOnAction(event);

	}
	public void EventHandlerToStartGame5(EventHandler<ActionEvent> event) {
		this.btnGame5.setOnAction(event);

	}
	public void EventHandlerToStartGame6(EventHandler<ActionEvent> event) {
		this.btnGame6.setOnAction(event);

	}
	public void EventHandlerToStartGame7(EventHandler<ActionEvent> event) {
		this.btnGame7.setOnAction(event);

	}

	public void EventHandlerToEndGame(EventHandler<ActionEvent> event) {
		this.btnDone.setOnAction(event);
	}




	

	/// get/set

	public String getParticipantsName() {
		return this.tfParticipantName.getText();
	}

	public void setTFParticipantsName(String name) {
		this.tfParticipantName.setText(name);
	}


	public boolean getRbBasketball() {
		return rbBasketball.isSelected();

	}

	public boolean getRbSoccer() {
		return rbSoccer.isSelected();

	}

	public boolean getRbTennis() {
		return rbTennis.isSelected();

	}


	public void setWinnerName(Participant participant, int index) { 
		if (index == 1) {
			this.winner1.setText(participant.getName());
		}
		if (index == 2) {
			this.winner2.setText(participant.getName());
		}
		if (index == 3) {
			this.winner3.setText(participant.getName());
		}
		if (index == 4) {
			this.winner4.setText(participant.getName());
		}
		if (index == 5) {
			this.winner5.setText(participant.getName());
		}
		if (index == 6) {
			this.winner6.setText(participant.getName());
		}
		if (index == 7) {
			this.winner7.setText(participant.getName());
		}



	}

	public void setParticipant1Name(Participant participant) {  
		this.participant1.setText(participant.getName());
	}

	public void setParticipant2Name(Participant participant) {  
		this.participant2.setText(participant.getName());
	}


	public Integer getTf1P1() throws Exception{
		return Integer.valueOf(this.tf1P1.getText());
	}
	public Integer getTf2P1() throws Exception{
		return Integer.valueOf(this.tf2P1.getText());
	}
	public Integer getTf3P1() throws Exception{
		return Integer.valueOf(this.tf3P1.getText());
	}
	public Integer getTf4P1() throws Exception{
		return Integer.valueOf(this.tf4P1.getText());
	}
	public Integer getTf5P1() throws Exception{
		return Integer.valueOf(this.tf5P1.getText());
	}



	public Integer getTf1P2() throws Exception{
		return Integer.valueOf(this.tf1P2.getText());
	}
	public Integer getTf2P2() throws Exception{
		return Integer.valueOf(this.tf2P2.getText());
	}
	public Integer getTf3P2() throws Exception{
		return Integer.valueOf(this.tf3P2.getText());
	}
	public Integer getTf4P2() throws Exception{
		return Integer.valueOf(this.tf4P2.getText());
	}
	public Integer getTf5P2() throws Exception{
		return Integer.valueOf(this.tf5P2.getText());
	}




	public void setMainScene() {
		Stage stage = new Stage();
		stage.setTitle("Championship");
		stage.setScene(this.scene);
		stage.show();


	}

	public void setMiniGamePlatform(int index) {
		Stage miniGameStage = new Stage();

		if (index == 0) {
			vbGameTennis();
			miniGameStage.setTitle("Tennis Game");
		}
		if (index == 1) {
			vbGameBasketball();
			miniGameStage.setTitle("Basketball Game");

		}
		if (index == 2) {
			vbGameSoccer();
			miniGameStage.setTitle("Soccer Game");
		}

		miniGameStage.setScene(this.miniGame);
		miniGameStage.show();

	}

	public void setTableScene() {
		Stage stage = new Stage();
		stage.setTitle("Championship Table");
		stage.setScene(this.tableScene);
		stage.show();

	}

	public void setParticipantsName(String name) {
		if (numOfParticipantsInTheChampionship==0) {
			player1.setText(name);
			player1T.setText(name);
			numOfParticipantsInTheChampionship++;
		}
		else if (numOfParticipantsInTheChampionship==1) {
			player2.setText(name);
			player2T.setText(name);
			numOfParticipantsInTheChampionship++;
		}
		else if (numOfParticipantsInTheChampionship==2) {
			player3.setText(name);
			player3T.setText(name);
			numOfParticipantsInTheChampionship++;
		}
		else if (numOfParticipantsInTheChampionship==3) {
			player4.setText(name);
			player4T.setText(name);
			numOfParticipantsInTheChampionship++;
		}
		else if (numOfParticipantsInTheChampionship==4) {
			player5.setText(name);
			player5T.setText(name);
			numOfParticipantsInTheChampionship++;
		}
		else if (numOfParticipantsInTheChampionship==5) {
			player6.setText(name);
			player6T.setText(name);
			numOfParticipantsInTheChampionship++;
		}
		else if (numOfParticipantsInTheChampionship==6) {
			player7.setText(name);
			player7T.setText(name);
			numOfParticipantsInTheChampionship++;
		}else if (numOfParticipantsInTheChampionship==7) {
			player8.setText(name);
			player8T.setText(name);
			numOfParticipantsInTheChampionship++;
		}


	}
	
	

}








