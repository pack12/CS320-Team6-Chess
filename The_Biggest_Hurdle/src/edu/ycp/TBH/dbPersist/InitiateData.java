package edu.ycp.TBH.dbPersist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.TBH.model.DB_GVal;

public class InitiateData {
	public static List<DB_GVal> getTrials() throws IOException {
		List<DB_GVal> trialList = new ArrayList<DB_GVal>();
		ReadCSV readTrials = new ReadCSV("games.csv");
		try {
			Integer trial_ID = 1;
			while (true) {
				List<String> tuple = readTrials.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				DB_GVal trial = new DB_GVal();
				trial.setID(trial_ID++);
				trial.setDate(i.next());
				trial.setForceVal(i.next());
				trialList.add(trial);
			}
			return trialList;
		} finally {
			readTrials.close();
		}
	}
}


