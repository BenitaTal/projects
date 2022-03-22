package Controller;


import Model.*;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller {
	private Model model;
	private View view;


	private int participantIndex = 0;
	private int semiFinalIndex = 0;
	private int finalIndex = 0;


	Participant w1;
	Participant w2;
	Participant w3;
	Participant w4;
	Participant w5;
	Participant w6;
	Participant w7;




	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		view.setMainScene();


		EventHandler<ActionEvent> EventHandlerToAddParticipantButton = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if ((!view.getRbBasketball()) && (!view.getRbSoccer()) && (!view.getRbTennis())) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("*** You Need To Choose Sport Type First ***");
					alert.show();
				}
				else {
					if (participantIndex <= 7) {
						if (!view.getParticipantsName().equals("")) {

							if (view.getRbBasketball()) {
								model.setQuarterFinalByParticipant(Basketball.class,model.addParticipantToChampionship(view.getParticipantsName()));
							}
							if (view.getRbSoccer()) {
								model.setQuarterFinalByParticipant(Soccer.class,model.addParticipantToChampionship(view.getParticipantsName()));
							}
							if (view.getRbTennis()) {
								model.setQuarterFinalByParticipant(Tennis.class,model.addParticipantToChampionship(view.getParticipantsName()));
							}

							view.setParticipantsName(view.getParticipantsName());
							view.setTFParticipantsName("");
							participantIndex++;

						}
						else {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("*** Please Add A Valid Name ***");
							alert.show();

						}
					}
					else {
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setContentText("*** There Is 8 Participant Already ***");
						alert.show();

					}
				}
			}
		};
		view.EventHandlerToAddParticipantButton(EventHandlerToAddParticipantButton);


		EventHandler<ActionEvent> EventHandlerToStartChampionshipButton = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				view.btnGame1.setDisable(false);
				view.btnGame2.setDisable(true);
				view.btnGame3.setDisable(true);
				view.btnGame4.setDisable(true);
				view.btnGame5.setDisable(true);
				view.btnGame6.setDisable(true);
				view.btnGame7.setDisable(true);



				if (participantIndex == 8 ) {
					view.setTableScene();
				}
				else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("*** You Need To Add 8 Participants ***");
					alert.show();
				}

			}
		};
		view.EventHandlerToStartChampionshipButton(EventHandlerToStartChampionshipButton);


		EventHandler<ActionEvent> EventHandlerToStartQuarterFinal = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if (view.getRbTennis()) {
					view.setMiniGamePlatform(0);

				}

				if (view.getRbBasketball()) {
					view.setMiniGamePlatform(1);

				}

				if (view.getRbSoccer()) {
					view.setMiniGamePlatform(2);
				}




				if (view.btnGame1.isArmed()) {
					view.setParticipant1Name(model.getChampionship().getQuarterFinal()[0].getTheFirstParticipant());
					view.setParticipant2Name(model.getChampionship().getQuarterFinal()[0].getTheSecondParticipant());
				}

				if (view.btnGame2.isArmed()) {
					view.setParticipant1Name(model.getChampionship().getQuarterFinal()[1].getTheFirstParticipant());
					view.setParticipant2Name(model.getChampionship().getQuarterFinal()[1].getTheSecondParticipant());

				}

				if (view.btnGame3.isArmed()) {
					view.setParticipant1Name(model.getChampionship().getQuarterFinal()[2].getTheFirstParticipant());
					view.setParticipant2Name(model.getChampionship().getQuarterFinal()[2].getTheSecondParticipant());

				}
				if (view.btnGame4.isArmed()) {
					view.setParticipant1Name(model.getChampionship().getQuarterFinal()[3].getTheFirstParticipant());
					view.setParticipant2Name(model.getChampionship().getQuarterFinal()[3].getTheSecondParticipant());

				}



			}
		};
		view.EventHandlerToStartGame1(EventHandlerToStartQuarterFinal);
		view.EventHandlerToStartGame2(EventHandlerToStartQuarterFinal);
		view.EventHandlerToStartGame3(EventHandlerToStartQuarterFinal);
		view.EventHandlerToStartGame4(EventHandlerToStartQuarterFinal);


		EventHandler<ActionEvent> EventHandlerToStartSemiFinal = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if (view.getRbTennis()) {
					view.setMiniGamePlatform(0);

				}

				if (view.getRbBasketball()) {
					view.setMiniGamePlatform(1);

				}

				if (view.getRbSoccer()) {
					view.setMiniGamePlatform(2);
				}



				if (view.btnGame5.isArmed()) {


					try {
						view.setParticipant1Name(w1);
						model.getChampionship().getSemiFinal()[0].setTheFirstParticipant(w1);

						view.setParticipant2Name(w2);
						model.getChampionship().getSemiFinal()[0].setTheSecondParticipant(w2);

					} catch (Exception e) {

					}





				}
				if (view.btnGame6.isArmed()) {


					try {
						view.setParticipant1Name(w3);
						model.getChampionship().getSemiFinal()[1].setTheFirstParticipant(w3);

						view.setParticipant2Name(w4);
						model.getChampionship().getSemiFinal()[1].setTheSecondParticipant(w4);

					} catch (Exception e) {

					}

				}




			}
		};
		view.EventHandlerToStartGame5(EventHandlerToStartSemiFinal);
		view.EventHandlerToStartGame6(EventHandlerToStartSemiFinal);



		EventHandler<ActionEvent> EventHandlerToStartFinal = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if (view.getRbTennis()) {
					view.setMiniGamePlatform(0);

				}

				else if (view.getRbBasketball()) {
					view.setMiniGamePlatform(1);

				}

				else if (view.getRbSoccer()) {
					view.setMiniGamePlatform(2);
				}



				if (view.btnGame7.isArmed()) {


					try {
						view.setParticipant1Name(w5);
						model.getChampionship().getTheFinal().setTheFirstParticipant(w5);

						view.setParticipant2Name(w6);
						model.getChampionship().getTheFinal().setTheSecondParticipant(w6);
					} 
					catch (Exception e) {

					}

				}



			}
		};
		view.EventHandlerToStartGame7(EventHandlerToStartFinal);



		EventHandler<ActionEvent> EventHandlerToEndGame = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				Alert alert2 = new Alert(Alert.AlertType.ERROR);


				if (semiFinalIndex <= 2) {
					if (view.getRbBasketball()) {
						model.getChampionship().setSemiFinalByGame(Basketball.class);
					}
					else if (view.getRbSoccer()) {
						model.getChampionship().setSemiFinalByGame(Soccer.class);
					}
					else if (view.getRbTennis()) {
						model.getChampionship().setSemiFinalByGame(Tennis.class);
					}
					semiFinalIndex++;
				} 

				if (finalIndex == 0) {
					if (view.getRbBasketball()) {
						model.getChampionship().setTheFinal(Basketball.class);
					}
					else if (view.getRbSoccer()) {
						model.getChampionship().setTheFinal(Soccer.class);
					}
					else if (view.getRbTennis()) {
						model.getChampionship().setTheFinal(Tennis.class);
					}
					finalIndex++;
				}

				Integer[] score1 = new Integer[5];
				Integer[] score2 = new Integer[5];

				if (view.getRbTennis()) {
					alert2.setContentText("*** The Score Is Not Valid, Please Try Again ***");

					try {

						score1[0] = view.getTf1P1();
						score1[1] = view.getTf2P1();
						score1[2] = view.getTf3P1();
						score1[3] = view.getTf4P1();
						score1[4] = view.getTf5P1();

						score2[0] = view.getTf1P2();
						score2[1] = view.getTf2P2();
						score2[2] = view.getTf3P2();
						score2[3] = view.getTf4P2();
						score2[4] = view.getTf5P2();


					} catch (Exception e) {
						alert.show();
					}


				}

				if (view.getRbBasketball() || view.getRbSoccer()) {
					alert2.setContentText("Its A Draw, Please Try Again");
					try {
						score1[0] = view.getTf1P1();
						score1[1] = view.getTf2P1();
						score1[2] = view.getTf3P1();
						score1[3] = view.getTf4P1();

						score2[0] = view.getTf1P2();
						score2[1] = view.getTf2P2();
						score2[2] = view.getTf3P2();
						score2[3] = view.getTf4P2();

					} catch (Exception e) {
						alert.show();						
					}

					score1[4] = 0;
					score2[4] = 0;

				}


				if(alert.getContentText().isEmpty()) {
					alert.setContentText("*** The Score Is Not Valid, Please Try Again ***");

					if (!view.btnGame1.isDisable() && view.btnGame2.isDisable()) {
						try {
							model.getChampionship().getQuarterFinal()[0].getTheFirstParticipant().setScore(score1);
							model.getChampionship().getQuarterFinal()[0].getTheSecondParticipant().setScore(score2);
							w1 = model.startQuarterFinalByIndex(0);

							if (model.getChampionship().getQuarterFinal()[0].getIsDraw()) {
								alert2.show();		}
							else {
								model.getChampionship().getSemiFinal()[0].setTheFirstParticipant(w1);
								view.setWinnerName(model.startQuarterFinalByIndex(0), 1);

								view.btnGame1.setDisable(true);
								view.btnGame2.setDisable(false);



							}

						} catch (Exception e) {

						}


					}

					else if (!view.btnGame2.isDisable() && view.btnGame3.isDisable()) {
						try {
							model.getChampionship().getQuarterFinal()[1].getTheFirstParticipant().setScore(score1);
							model.getChampionship().getQuarterFinal()[1].getTheSecondParticipant().setScore(score2);
							w2 = model.startQuarterFinalByIndex(1);

							if (model.getChampionship().getQuarterFinal()[1].getIsDraw()) {
								alert2.show();

							}
							else {
								model.getChampionship().getSemiFinal()[0].setTheSecondParticipant(w2);
								view.setWinnerName(model.startQuarterFinalByIndex(1), 2);

								view.btnGame2.setDisable(true);
								view.btnGame3.setDisable(false);
							}


						} catch (Exception e) {

						}



					}
					else if (!view.btnGame3.isDisable() && view.btnGame4.isDisable()) {

						try {
							model.getChampionship().getQuarterFinal()[2].getTheFirstParticipant().setScore(score1);
							model.getChampionship().getQuarterFinal()[2].getTheSecondParticipant().setScore(score2);
							w3 = model.startQuarterFinalByIndex(2);

							if (model.getChampionship().getQuarterFinal()[2].getIsDraw()) {
								alert2.show();


							}
							else {
								model.getChampionship().getSemiFinal()[1].setTheFirstParticipant(w3);
								view.setWinnerName(model.startQuarterFinalByIndex(2), 3);

								view.btnGame3.setDisable(true);
								view.btnGame4.setDisable(false);
							}

						} catch (Exception e) {

						}


					}
					else if (!view.btnGame4.isDisable() && view.btnGame3.isDisable() && view.btnGame2.isDisable()&& view.btnGame1.isDisable()) {

						try {
							model.getChampionship().getQuarterFinal()[3].getTheFirstParticipant().setScore(score1);
							model.getChampionship().getQuarterFinal()[3].getTheSecondParticipant().setScore(score2);
							w4 = model.startQuarterFinalByIndex(3);

							if (model.getChampionship().getQuarterFinal()[3].getIsDraw()) {

								alert2.show();
							}
							else {
								model.getChampionship().getSemiFinal()[1].setTheSecondParticipant(w4);
								view.setWinnerName(model.startQuarterFinalByIndex(3), 4);

								view.btnGame4.setDisable(true);
								view.btnGame5.setDisable(false);

							}

						} catch (Exception e) {

						}


					}


					else if (!view.btnGame5.isDisable() && view.btnGame4.isDisable()) {
						try {
							model.getChampionship().getSemiFinal()[0].getTheFirstParticipant().setScore(score1);
							model.getChampionship().getSemiFinal()[0].getTheSecondParticipant().setScore(score2);
							w5 = model.startSemiFinalByIndex(0);

							if (model.getChampionship().getSemiFinal()[0].getIsDraw()) {
								alert2.show();
							}
							else {
								model.getChampionship().getTheFinal().setTheFirstParticipant(w5);
								view.setWinnerName(model.startSemiFinalByIndex(0),5);

								view.btnGame5.setDisable(true);
								view.btnGame6.setDisable(false);


							}


						} catch (Exception e) {

						}


					}

					else if (!view.btnGame6.isDisable() && view.btnGame5.isDisable()) {
						try {
							model.getChampionship().getSemiFinal()[1].getTheFirstParticipant().setScore(score1);
							model.getChampionship().getSemiFinal()[1].getTheSecondParticipant().setScore(score2);
							w6 = model.startSemiFinalByIndex(1);

							if (model.getChampionship().getSemiFinal()[1].getIsDraw()) {
								alert2.show();

							}
							else {
								model.getChampionship().getTheFinal().setTheSecondParticipant(w6);
								view.setWinnerName(model.startSemiFinalByIndex(1), 6);

								view.btnGame6.setDisable(true);
								view.btnGame7.setDisable(false);

							}

						} catch (Exception e) {

						}


					}

					else if (!view.btnGame7.isDisable() && view.btnGame6.isDisable()) {
						try {
							model.getChampionship().getTheFinal().getTheFirstParticipant().setScore(score1);
							model.getChampionship().getTheFinal().getTheSecondParticipant().setScore(score2);
							w7 = model.startFinal();

							if (model.getChampionship().getTheFinal().getIsDraw()) {
								alert2.show();
							}
							else {
								model.getChampionship().setTheCampion(w7);
								view.setWinnerName(model.startFinal(), 7);

								view.btnGame7.setDisable(true);

								Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
								alert1.setContentText("The Winner Is "+ model.getChampionship().getTheChampion().getName()+" !!!"+"\nHave A Great Day");
								alert1.setTitle("Campionship");
								alert1.show();


							}

						} 
						catch (Exception e) {

						}


					}
				}else
					alert.show();

				closeButtonAction();

			}

		};
		view.EventHandlerToEndGame(EventHandlerToEndGame);

	}

	private void closeButtonAction(){
		Stage stage = (Stage) view.btnDone.getScene().getWindow();

		stage.close();
	}




}
