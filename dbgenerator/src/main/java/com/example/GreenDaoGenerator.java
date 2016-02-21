package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.shixipai.dbgenerator");

        addPostJobId(schema);

        new DaoGenerator().generateAll(schema, "/Users/xiepeng/Desktop/实习派/ShiXiPai/app/src/main/db-gen");
    }

    /**
     * @param schema
     */
    private static void addPostJobId(Schema schema) {
        Entity jobId = schema.addEntity("PostedJob");

        jobId.addIdProperty();
        jobId.addIntProperty("post_job_id");
    }
}
