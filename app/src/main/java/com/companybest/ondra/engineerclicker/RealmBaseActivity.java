package com.companybest.ondra.engineerclicker;

import android.support.v7.app.AppCompatActivity;

import com.companybest.ondra.engineerclicker.References.MyMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public abstract class RealmBaseActivity extends AppCompatActivity {

    private RealmConfiguration realmConfiguration;

    protected RealmConfiguration getRealmConfig() {
        Realm.init(this);
        if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration
                    .Builder()
                    .migration( new MyMigration())
                    .build();
        }

        return realmConfiguration;
    }

    protected void resetRealm() {
        Realm.deleteRealm(getRealmConfig());
    }
}
