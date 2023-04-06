package com.example.task14;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import static com.example.task14.ActionChain.SUCCESS;


public class PositiveHandler extends Handler{

    Player player;
    public PositiveHandler(Handler processor, Player player) {
        super(processor);
        this.player = player;
    }

    //HelloController helloController = new HelloController();


    public boolean process(Integer request) {

        if (request != SUCCESS) return super.process(request);// не свой запрос передается дальше по цепочке

        else {//свой, обрабатывается здесь

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Вы выиграли!");

            alert.setHeaderText("Повезло!");

            player.addNumber(2);
            player.addWins(1);



            ButtonType replay = new ButtonType("Продолжить играть", ButtonBar.ButtonData.YES);

            //ButtonType vacation = new ButtonType("Отдохнуть", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().clear();

            alert.getButtonTypes().addAll(replay);

            alert.showAndWait();
            return true;
        }
    }
}
