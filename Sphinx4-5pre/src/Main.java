import java.io.FileInputStream;
import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.result.WordResult;
import edu.cmu.sphinx.tools.batch.BatchModeRecognizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Configuration configuration = new Configuration();
		
		// Set path to acoustic model.
		configuration.setAcousticModelPath("/home/emerson/sphinx3nightly/an4/model_parameters/teste");
		// Set path to dictionary.
		configuration.setDictionaryPath("/home/emerson/sphinx3nightly/an4/etc/an4.dic");
		// Set language model.
		configuration.setLanguageModelPath("/home/emerson/sphinx3nightly/an4/etc/an4.ug.lm");

		StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
		recognizer.startRecognition(new FileInputStream("/home/emerson/sphinx3nightly/an4/wav/Reconhecimento/F051702.WAV"));
		SpeechResult result = recognizer.getResult();
		recognizer.stopRecognition();

		// Print utterance string without filler words.
		System.out.println(result.getHypothesis());
		
		// Get individual words and their times.
		//for (WordResult r : result.getWords()) {
		    //System.out.println(r);
		//}

	}

}
