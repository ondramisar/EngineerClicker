package com.companybest.ondra.engineerclicker.References;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;


public class MyMigration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {


        // DynamicRealm exposes an editable schema
        RealmSchema schema = realm.getSchema();

        // Migrate from version 0 to version 1
        if (oldVersion == 0) {
            RealmObjectSchema userScheme = schema.get("User");

            userScheme
                    .addField("maxMachine", int.class, FieldAttribute.INDEXED)
                    .addField("maxWorkers", int.class, FieldAttribute.INDEXED)
                    .addField("maxUpgrade", int.class, FieldAttribute.INDEXED);

            oldVersion++;
        }

    }
}

