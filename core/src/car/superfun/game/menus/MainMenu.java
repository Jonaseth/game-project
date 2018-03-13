package car.superfun.game.menus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import car.superfun.game.CarSuperFun;
import car.superfun.game.states.GameStateManager;
import car.superfun.game.states.State;

/**
 * Created by Jonas on 06.03.2018.
 */

public class MainMenu extends State {
    private Texture background, hostButton, joinButton, settings;

    public MainMenu(){
        background = new Texture("background.png");
        hostButton = new Texture("menu-buttons/host.png");
        joinButton = new Texture("menu-buttons/hostb.png");
        settings = new Texture("menu-buttons/settings.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            //Gdx.app.log("X", Integer.toString(Gdx.input.getX()));
            //Gdx.app.log("Y", Integer.toString(Gdx.input.getY()));
            // height: 1080, width: 1796
            if(isOnHost()){
                GameStateManager.getInstance().push(new SettingsMenu());
            }
            if(isOnJoin()){
                GameStateManager.getInstance().push(new SettingsMenu());
            }
            if(isOnSettings()){
                Gdx.app.log("Touched", "heyo");
                GameStateManager.getInstance().push(new SettingsMenu());
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(hostButton, Gdx.graphics.getWidth()/2-hostButton.getWidth()/2, Gdx.graphics.getHeight()/2+150);
        sb.draw(joinButton, Gdx.graphics.getWidth()/2-hostButton.getWidth()/2, Gdx.graphics.getHeight()/2-150);
        sb.draw(settings, 1600, 890);
        sb.end();
    }

    @Override
    public void dispose() {
        settings.dispose();
        hostButton.dispose();
        joinButton.dispose();
        background.dispose();
    }

    public boolean isOnJoin(){
        Rectangle textureBounds = new Rectangle((Gdx.graphics.getWidth()/2-hostButton.getWidth()/2), (Gdx.graphics.getHeight()/2-350), (hostButton.getWidth()), hostButton.getHeight());
        if(textureBounds.contains(Gdx.input.getX(), Gdx.input.getY())){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOnHost(){
        Rectangle textureBounds = new Rectangle((Gdx.graphics.getWidth()/2-hostButton.getWidth()/2), (Gdx.graphics.getHeight()/2-50), (hostButton.getWidth()), hostButton.getHeight());
        if(textureBounds.contains(Gdx.input.getX(), Gdx.input.getY())){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOnSettings(){
        Circle textureBounds = new Circle(1600+settings.getWidth()/2, (Gdx.graphics.getHeight() - 890)-settings.getHeight()/2, settings.getWidth()/2);
        if(textureBounds.contains(Gdx.input.getX(), Gdx.input.getY())){
            return true;
        }else{
            return false;
        }
    }
}