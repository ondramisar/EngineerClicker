package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserRealmProxy extends com.companybest.ondra.engineerclicker.Models.User
    implements RealmObjectProxy, UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo
        implements Cloneable {

        public long nameIndex;
        public long levelIndex;
        public long expNeededIndex;
        public long expIndex;
        public long coinsIndex;
        public long maxMachineIndex;
        public long maxWorkersIndex;
        public long maxUpgradeIndex;

        UserColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(8);
            this.nameIndex = getValidColumnIndex(path, table, "User", "name");
            indicesMap.put("name", this.nameIndex);
            this.levelIndex = getValidColumnIndex(path, table, "User", "level");
            indicesMap.put("level", this.levelIndex);
            this.expNeededIndex = getValidColumnIndex(path, table, "User", "expNeeded");
            indicesMap.put("expNeeded", this.expNeededIndex);
            this.expIndex = getValidColumnIndex(path, table, "User", "exp");
            indicesMap.put("exp", this.expIndex);
            this.coinsIndex = getValidColumnIndex(path, table, "User", "coins");
            indicesMap.put("coins", this.coinsIndex);
            this.maxMachineIndex = getValidColumnIndex(path, table, "User", "maxMachine");
            indicesMap.put("maxMachine", this.maxMachineIndex);
            this.maxWorkersIndex = getValidColumnIndex(path, table, "User", "maxWorkers");
            indicesMap.put("maxWorkers", this.maxWorkersIndex);
            this.maxUpgradeIndex = getValidColumnIndex(path, table, "User", "maxUpgrade");
            indicesMap.put("maxUpgrade", this.maxUpgradeIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final UserColumnInfo otherInfo = (UserColumnInfo) other;
            this.nameIndex = otherInfo.nameIndex;
            this.levelIndex = otherInfo.levelIndex;
            this.expNeededIndex = otherInfo.expNeededIndex;
            this.expIndex = otherInfo.expIndex;
            this.coinsIndex = otherInfo.coinsIndex;
            this.maxMachineIndex = otherInfo.maxMachineIndex;
            this.maxWorkersIndex = otherInfo.maxWorkersIndex;
            this.maxUpgradeIndex = otherInfo.maxUpgradeIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final UserColumnInfo clone() {
            return (UserColumnInfo) super.clone();
        }

    }
    private UserColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("level");
        fieldNames.add("expNeeded");
        fieldNames.add("exp");
        fieldNames.add("coins");
        fieldNames.add("maxMachine");
        fieldNames.add("maxWorkers");
        fieldNames.add("maxUpgrade");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    UserRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.companybest.ondra.engineerclicker.Models.User.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'name' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public int realmGet$level() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.levelIndex);
    }

    public void realmSet$level(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.levelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.levelIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$expNeeded() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.expNeededIndex);
    }

    public void realmSet$expNeeded(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.expNeededIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.expNeededIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$exp() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.expIndex);
    }

    public void realmSet$exp(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.expIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.expIndex, value);
    }

    @SuppressWarnings("cast")
    public float realmGet$coins() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.coinsIndex);
    }

    public void realmSet$coins(float value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.coinsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.coinsIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$maxMachine() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxMachineIndex);
    }

    public void realmSet$maxMachine(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.maxMachineIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.maxMachineIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$maxWorkers() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxWorkersIndex);
    }

    public void realmSet$maxWorkers(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.maxWorkersIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.maxWorkersIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$maxUpgrade() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxUpgradeIndex);
    }

    public void realmSet$maxUpgrade(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.maxUpgradeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.maxUpgradeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("User")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("User");
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("level", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("expNeeded", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("exp", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("coins", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("maxMachine", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("maxWorkers", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("maxUpgrade", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("User");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_User")) {
            Table table = sharedRealm.getTable("class_User");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "level", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "expNeeded", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "exp", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.FLOAT, "coins", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "maxMachine", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "maxWorkers", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "maxUpgrade", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("name"));
            table.setPrimaryKey("name");
            return table;
        }
        return sharedRealm.getTable("class_User");
    }

    public static UserColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_User")) {
            Table table = sharedRealm.getTable("class_User");
            final long columnCount = table.getColumnCount();
            if (columnCount != 8) {
                if (columnCount < 8) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 8 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 8 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 8 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final UserColumnInfo columnInfo = new UserColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'name' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'name' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("name"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'name' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("level")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'level' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("level") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'level' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.levelIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'level' does support null values in the existing Realm file. Use corresponding boxed type for field 'level' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("expNeeded")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'expNeeded' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("expNeeded") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'expNeeded' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.expNeededIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'expNeeded' does support null values in the existing Realm file. Use corresponding boxed type for field 'expNeeded' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("exp")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'exp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("exp") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'exp' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.expIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'exp' does support null values in the existing Realm file. Use corresponding boxed type for field 'exp' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("coins")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'coins' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("coins") != RealmFieldType.FLOAT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'float' for field 'coins' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.coinsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'coins' does support null values in the existing Realm file. Use corresponding boxed type for field 'coins' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("maxMachine")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxMachine' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("maxMachine") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxMachine' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.maxMachineIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxMachine' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxMachine' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("maxWorkers")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxWorkers' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("maxWorkers") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxWorkers' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.maxWorkersIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxWorkers' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxWorkers' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("maxUpgrade")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxUpgrade' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("maxUpgrade") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxUpgrade' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.maxUpgradeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxUpgrade' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxUpgrade' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'User' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_User";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.companybest.ondra.engineerclicker.Models.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.companybest.ondra.engineerclicker.Models.User obj = null;
        if (update) {
            Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.User.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("name")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("name"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("name")) {
                if (json.isNull("name")) {
                    obj = (io.realm.UserRealmProxy) realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.UserRealmProxy) realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.User.class, json.getString("name"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'name'.");
            }
        }
        if (json.has("level")) {
            if (json.isNull("level")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'level' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$level((int) json.getInt("level"));
            }
        }
        if (json.has("expNeeded")) {
            if (json.isNull("expNeeded")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'expNeeded' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$expNeeded((int) json.getInt("expNeeded"));
            }
        }
        if (json.has("exp")) {
            if (json.isNull("exp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'exp' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$exp((int) json.getInt("exp"));
            }
        }
        if (json.has("coins")) {
            if (json.isNull("coins")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'coins' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$coins((float) json.getDouble("coins"));
            }
        }
        if (json.has("maxMachine")) {
            if (json.isNull("maxMachine")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxMachine' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$maxMachine((int) json.getInt("maxMachine"));
            }
        }
        if (json.has("maxWorkers")) {
            if (json.isNull("maxWorkers")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxWorkers' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$maxWorkers((int) json.getInt("maxWorkers"));
            }
        }
        if (json.has("maxUpgrade")) {
            if (json.isNull("maxUpgrade")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxUpgrade' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$maxUpgrade((int) json.getInt("maxUpgrade"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.companybest.ondra.engineerclicker.Models.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.companybest.ondra.engineerclicker.Models.User obj = new com.companybest.ondra.engineerclicker.Models.User();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("level")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'level' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$level((int) reader.nextInt());
                }
            } else if (name.equals("expNeeded")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'expNeeded' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$expNeeded((int) reader.nextInt());
                }
            } else if (name.equals("exp")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'exp' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$exp((int) reader.nextInt());
                }
            } else if (name.equals("coins")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'coins' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$coins((float) reader.nextDouble());
                }
            } else if (name.equals("maxMachine")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxMachine' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$maxMachine((int) reader.nextInt());
                }
            } else if (name.equals("maxWorkers")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxWorkers' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$maxWorkers((int) reader.nextInt());
                }
            } else if (name.equals("maxUpgrade")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxUpgrade' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$maxUpgrade((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'name'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.companybest.ondra.engineerclicker.Models.User copyOrUpdate(Realm realm, com.companybest.ondra.engineerclicker.Models.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.companybest.ondra.engineerclicker.Models.User) cachedRealmObject;
        } else {
            com.companybest.ondra.engineerclicker.Models.User realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.User.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((UserRealmProxyInterface) object).realmGet$name();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.User.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.UserRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.companybest.ondra.engineerclicker.Models.User copy(Realm realm, com.companybest.ondra.engineerclicker.Models.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.companybest.ondra.engineerclicker.Models.User) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.companybest.ondra.engineerclicker.Models.User realmObject = realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.User.class, ((UserRealmProxyInterface) newObject).realmGet$name(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((UserRealmProxyInterface) realmObject).realmSet$level(((UserRealmProxyInterface) newObject).realmGet$level());
            ((UserRealmProxyInterface) realmObject).realmSet$expNeeded(((UserRealmProxyInterface) newObject).realmGet$expNeeded());
            ((UserRealmProxyInterface) realmObject).realmSet$exp(((UserRealmProxyInterface) newObject).realmGet$exp());
            ((UserRealmProxyInterface) realmObject).realmSet$coins(((UserRealmProxyInterface) newObject).realmGet$coins());
            ((UserRealmProxyInterface) realmObject).realmSet$maxMachine(((UserRealmProxyInterface) newObject).realmGet$maxMachine());
            ((UserRealmProxyInterface) realmObject).realmSet$maxWorkers(((UserRealmProxyInterface) newObject).realmGet$maxWorkers());
            ((UserRealmProxyInterface) realmObject).realmSet$maxUpgrade(((UserRealmProxyInterface) newObject).realmGet$maxUpgrade());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.companybest.ondra.engineerclicker.Models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$name();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.levelIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$level(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.expNeededIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$expNeeded(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.expIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$exp(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.coinsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$coins(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxMachineIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxMachine(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxWorkersIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxWorkers(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxUpgradeIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxUpgrade(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.companybest.ondra.engineerclicker.Models.User object = null;
        while (objects.hasNext()) {
            object = (com.companybest.ondra.engineerclicker.Models.User) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$name();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.levelIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$level(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.expNeededIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$expNeeded(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.expIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$exp(), false);
                Table.nativeSetFloat(tableNativePtr, columnInfo.coinsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$coins(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxMachineIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxMachine(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxWorkersIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxWorkers(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxUpgradeIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxUpgrade(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.companybest.ondra.engineerclicker.Models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$name();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.levelIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$level(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.expNeededIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$expNeeded(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.expIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$exp(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.coinsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$coins(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxMachineIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxMachine(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxWorkersIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxWorkers(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxUpgradeIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxUpgrade(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.companybest.ondra.engineerclicker.Models.User object = null;
        while (objects.hasNext()) {
            object = (com.companybest.ondra.engineerclicker.Models.User) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$name();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.levelIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$level(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.expNeededIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$expNeeded(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.expIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$exp(), false);
                Table.nativeSetFloat(tableNativePtr, columnInfo.coinsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$coins(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxMachineIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxMachine(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxWorkersIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxWorkers(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxUpgradeIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$maxUpgrade(), false);
            }
        }
    }

    public static com.companybest.ondra.engineerclicker.Models.User createDetachedCopy(com.companybest.ondra.engineerclicker.Models.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.companybest.ondra.engineerclicker.Models.User unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.companybest.ondra.engineerclicker.Models.User)cachedObject.object;
            } else {
                unmanagedObject = (com.companybest.ondra.engineerclicker.Models.User)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.companybest.ondra.engineerclicker.Models.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((UserRealmProxyInterface) unmanagedObject).realmSet$name(((UserRealmProxyInterface) realmObject).realmGet$name());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$level(((UserRealmProxyInterface) realmObject).realmGet$level());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$expNeeded(((UserRealmProxyInterface) realmObject).realmGet$expNeeded());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$exp(((UserRealmProxyInterface) realmObject).realmGet$exp());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$coins(((UserRealmProxyInterface) realmObject).realmGet$coins());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$maxMachine(((UserRealmProxyInterface) realmObject).realmGet$maxMachine());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$maxWorkers(((UserRealmProxyInterface) realmObject).realmGet$maxWorkers());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$maxUpgrade(((UserRealmProxyInterface) realmObject).realmGet$maxUpgrade());
        return unmanagedObject;
    }

    static com.companybest.ondra.engineerclicker.Models.User update(Realm realm, com.companybest.ondra.engineerclicker.Models.User realmObject, com.companybest.ondra.engineerclicker.Models.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((UserRealmProxyInterface) realmObject).realmSet$level(((UserRealmProxyInterface) newObject).realmGet$level());
        ((UserRealmProxyInterface) realmObject).realmSet$expNeeded(((UserRealmProxyInterface) newObject).realmGet$expNeeded());
        ((UserRealmProxyInterface) realmObject).realmSet$exp(((UserRealmProxyInterface) newObject).realmGet$exp());
        ((UserRealmProxyInterface) realmObject).realmSet$coins(((UserRealmProxyInterface) newObject).realmGet$coins());
        ((UserRealmProxyInterface) realmObject).realmSet$maxMachine(((UserRealmProxyInterface) newObject).realmGet$maxMachine());
        ((UserRealmProxyInterface) realmObject).realmSet$maxWorkers(((UserRealmProxyInterface) newObject).realmGet$maxWorkers());
        ((UserRealmProxyInterface) realmObject).realmSet$maxUpgrade(((UserRealmProxyInterface) newObject).realmGet$maxUpgrade());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = [");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{level:");
        stringBuilder.append(realmGet$level());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{expNeeded:");
        stringBuilder.append(realmGet$expNeeded());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{exp:");
        stringBuilder.append(realmGet$exp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{coins:");
        stringBuilder.append(realmGet$coins());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxMachine:");
        stringBuilder.append(realmGet$maxMachine());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxWorkers:");
        stringBuilder.append(realmGet$maxWorkers());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxUpgrade:");
        stringBuilder.append(realmGet$maxUpgrade());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRealmProxy aUser = (UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
