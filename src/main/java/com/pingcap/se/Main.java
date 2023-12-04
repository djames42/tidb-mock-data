package com.pingcap.se;

import com.pingcap.se.database.Aurora;
import com.pingcap.se.models.JsonExtensions;
import com.pingcap.se.models.TestTable;
import com.pingcap.se.services.GetProperties;
import com.pingcap.se.services.Randomise;

import static java.lang.System.getProperty;

public class Main {
    public static void main(String[] args) {
        String propFile = getProperty("PROP_FILE");
        Aurora aurora = new Aurora(propFile);
        Randomise randomise = new Randomise();
        JsonExtensions jsonExtension;
        Integer recordsToCreate = 20;
        if ( System.getProperty("NUM_RECORDS") != null ) recordsToCreate = Integer.valueOf(System.getProperty("NUM_RECORDS"));
        while (recordsToCreate-- > 0 ) {
            jsonExtension = new JsonExtensions();
            TestTable testTable = new TestTable(randomise.randomInt(255), randomise.randomInt(65535),
                    randomise.randomString(20), randomise.randomFloat(), randomise.randomFloat(), jsonExtension.toJSON());
            aurora.insertRow(testTable);
            if ( recordsToCreate % 25000 == 0 ) {
                System.out.printf("Count: %8d\n", recordsToCreate);
            }
        }
    }
}