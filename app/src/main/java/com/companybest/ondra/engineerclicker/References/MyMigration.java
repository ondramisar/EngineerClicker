package com.companybest.ondra.engineerclicker.References;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;


public class MyMigration implements RealmMigration {


    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        // DynamicRealm exposes an editable schema
        RealmSchema schema = realm.getSchema();
        /*
        schema.get("User")
                .addField("level", int.class)
                .addField("expNeeded", int.class)
                .addField("exp", int.class);*/
    }
}

