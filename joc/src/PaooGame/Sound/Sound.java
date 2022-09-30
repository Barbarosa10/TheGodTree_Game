package PaooGame.Sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[5];
    public Sound(){
        soundURL[0] = getClass().getResource("/Sound/game_song.mp3");
        soundURL[1] = getClass().getResource("/Sound/hitmonster.mp3");
        soundURL[2] = getClass().getResource("/Sound/receivedamage.mp3");
        soundURL[3] = getClass().getResource("/Sound/key.mp3");
    }
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    // public void stoploop(){clip.loop();}
    public void stop(){
        clip.stop();
    }
    public void pause(){clip.getMicrosecondPosition();
        clip.stop();}
}
