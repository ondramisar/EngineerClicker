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

public class UpgradeRealmProxy extends com.companybest.ondra.engineerclicker.Models.Upgrade
    implements RealmObjectProxy, UpgradeRealmProxyInterface {

    static final class UpgradeColumnInfo extends ColumnInfo
        implements Cloneable {

        public long nameIndex;
        public long nameOfMachinetoGiveIndex;
        public long nameOfMaterialGiveIndex;
        public long forWhatToDoIndex;
        public long costIndex;
        public long whatDoIndex;
        public long nameOfImgIndex;

        UpgradeColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(7);
            this.nameIndex = getValidColumnIndex(path, table, "Upgrade", "name");
            indicesMap.put("name", this.nameIndex);
            this.nameOfMachinetoGiveIndex = getValidColumnIndex(path, table, "Upgrade", "nameOfMachinetoGive");
            indicesMap.put("nameOfMachinetoGive", this.nameOfMachinetoGiveIndex);
            this.nameOfMaterialGiveIndex = getValidColumnIndex(path, table, "Upgrade", "nameOfMaterialGive");
            indicesMap.put("nameOfMaterialGive", this.nameOfMaterialGiveIndex);
            this.forWhatToDoIndex = getValidColumnIndex(path, table, "Upgrade", "forWhatToDo");
            indicesMap.put("forWhatToDo", this.forWhatToDoIndex);
            this.costIndex = getValidColumnIndex(path, table, "Upgrade", "cost");
            indicesMap.put("cost", this.costIndex);
            this.whatDoIndex = getValidColumnIndex(path, table, "Upgrade", "whatDo");
            indicesMap.put("whatDo", this.whatDoIndex);
            this.nameOfImgIndex = getValidColumnIndex(path, table, "Upgrade", "nameOfImg");
            indicesMap.put("nameOfImg", this.nameOfImgIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final UpgradeColumnInfo otherInfo = (UpgradeColumnInfo) other;
            this.nameIndex = otherInfo.nameIndex;
            this.nameOfMachinetoGiveIndex = otherInfo.nameOfMachinetoGiveIndex;
            this.nameOfMaterialGiveIndex = otherInfo.nameOfMaterialGiveIndex;
            this.forWhatToDoIndex = otherInfo.forWhatToDoIndex;
            this.costIndex = otherInfo.costIndex;
            this.whatDoIndex = otherInfo.whatDoIndex;
            this.nameOfImgIndex = otherInfo.nameOfImgIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final UpgradeColumnInfo clone() {
            return (UpgradeColumnInfo) super.clone();
        }

    }
    private UpgradeColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("nameOfMachinetoGive");
        fieldNames.add("nameOfMaterialGive");
        fieldNames.add("forWhatToDo");
        fieldNames.add("cost");
        fieldNames.add("whatDo");
        fieldNames.add("nameOfImg");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    UpgradeRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UpgradeColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.companybest.ondra.engineerclicker.Models.Upgrade.class, this);
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
    public String realmGet$nameOfMachinetoGive() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameOfMachinetoGiveIndex);
    }

    public void realmSet$nameOfMachinetoGive(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameOfMachinetoGiveIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameOfMachinetoGiveIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameOfMachinetoGiveIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameOfMachinetoGiveIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$nameOfMaterialGive() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameOfMaterialGiveIndex);
    }

    public void realmSet$nameOfMaterialGive(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameOfMaterialGiveIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameOfMaterialGiveIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameOfMaterialGiveIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameOfMaterialGiveIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$forWhatToDo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.forWhatToDoIndex);
    }

    public void realmSet$forWhatToDo(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.forWhatToDoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.forWhatToDoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.forWhatToDoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.forWhatToDoIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$cost() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.costIndex);
    }

    public void realmSet$cost(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.costIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.costIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$whatDo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.whatDoIndex);
    }

    public void realmSet$whatDo(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.whatDoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.whatDoIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$nameOfImg() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameOfImgIndex);
    }

    public void realmSet$nameOfImg(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameOfImgIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameOfImgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameOfImgIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameOfImgIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Upgrade")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Upgrade");
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("nameOfMachinetoGive", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("nameOfMaterialGive", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("forWhatToDo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cost", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("whatDo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("nameOfImg", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Upgrade");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Upgrade")) {
            Table table = sharedRealm.getTable("class_Upgrade");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "nameOfMachinetoGive", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "nameOfMaterialGive", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "forWhatToDo", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cost", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "whatDo", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "nameOfImg", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("name"));
            table.setPrimaryKey("name");
            return table;
        }
        return sharedRealm.getTable("class_Upgrade");
    }

    public static UpgradeColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Upgrade")) {
            Table table = sharedRealm.getTable("class_Upgrade");
            final long columnCount = table.getColumnCount();
            if (columnCount != 7) {
                if (columnCount < 7) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final UpgradeColumnInfo columnInfo = new UpgradeColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("nameOfMachinetoGive")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameOfMachinetoGive' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nameOfMachinetoGive") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameOfMachinetoGive' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameOfMachinetoGiveIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameOfMachinetoGive' is required. Either set @Required to field 'nameOfMachinetoGive' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("nameOfMaterialGive")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameOfMaterialGive' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nameOfMaterialGive") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameOfMaterialGive' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameOfMaterialGiveIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameOfMaterialGive' is required. Either set @Required to field 'nameOfMaterialGive' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("forWhatToDo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'forWhatToDo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("forWhatToDo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'forWhatToDo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.forWhatToDoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'forWhatToDo' is required. Either set @Required to field 'forWhatToDo' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cost")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cost") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cost' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.costIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cost' does support null values in the existing Realm file. Use corresponding boxed type for field 'cost' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("whatDo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'whatDo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("whatDo") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'whatDo' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.whatDoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'whatDo' does support null values in the existing Realm file. Use corresponding boxed type for field 'whatDo' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("nameOfImg")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameOfImg' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nameOfImg") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameOfImg' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameOfImgIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameOfImg' is required. Either set @Required to field 'nameOfImg' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Upgrade' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Upgrade";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.companybest.ondra.engineerclicker.Models.Upgrade createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.companybest.ondra.engineerclicker.Models.Upgrade obj = null;
        if (update) {
            Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Upgrade.class), false, Collections.<String> emptyList());
                    obj = new io.realm.UpgradeRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("name")) {
                if (json.isNull("name")) {
                    obj = (io.realm.UpgradeRealmProxy) realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.Upgrade.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.UpgradeRealmProxy) realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.Upgrade.class, json.getString("name"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'name'.");
            }
        }
        if (json.has("nameOfMachinetoGive")) {
            if (json.isNull("nameOfMachinetoGive")) {
                ((UpgradeRealmProxyInterface) obj).realmSet$nameOfMachinetoGive(null);
            } else {
                ((UpgradeRealmProxyInterface) obj).realmSet$nameOfMachinetoGive((String) json.getString("nameOfMachinetoGive"));
            }
        }
        if (json.has("nameOfMaterialGive")) {
            if (json.isNull("nameOfMaterialGive")) {
                ((UpgradeRealmProxyInterface) obj).realmSet$nameOfMaterialGive(null);
            } else {
                ((UpgradeRealmProxyInterface) obj).realmSet$nameOfMaterialGive((String) json.getString("nameOfMaterialGive"));
            }
        }
        if (json.has("forWhatToDo")) {
            if (json.isNull("forWhatToDo")) {
                ((UpgradeRealmProxyInterface) obj).realmSet$forWhatToDo(null);
            } else {
                ((UpgradeRealmProxyInterface) obj).realmSet$forWhatToDo((String) json.getString("forWhatToDo"));
            }
        }
        if (json.has("cost")) {
            if (json.isNull("cost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
            } else {
                ((UpgradeRealmProxyInterface) obj).realmSet$cost((int) json.getInt("cost"));
            }
        }
        if (json.has("whatDo")) {
            if (json.isNull("whatDo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'whatDo' to null.");
            } else {
                ((UpgradeRealmProxyInterface) obj).realmSet$whatDo((int) json.getInt("whatDo"));
            }
        }
        if (json.has("nameOfImg")) {
            if (json.isNull("nameOfImg")) {
                ((UpgradeRealmProxyInterface) obj).realmSet$nameOfImg(null);
            } else {
                ((UpgradeRealmProxyInterface) obj).realmSet$nameOfImg((String) json.getString("nameOfImg"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.companybest.ondra.engineerclicker.Models.Upgrade createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.companybest.ondra.engineerclicker.Models.Upgrade obj = new com.companybest.ondra.engineerclicker.Models.Upgrade();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UpgradeRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((UpgradeRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("nameOfMachinetoGive")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UpgradeRealmProxyInterface) obj).realmSet$nameOfMachinetoGive(null);
                } else {
                    ((UpgradeRealmProxyInterface) obj).realmSet$nameOfMachinetoGive((String) reader.nextString());
                }
            } else if (name.equals("nameOfMaterialGive")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UpgradeRealmProxyInterface) obj).realmSet$nameOfMaterialGive(null);
                } else {
                    ((UpgradeRealmProxyInterface) obj).realmSet$nameOfMaterialGive((String) reader.nextString());
                }
            } else if (name.equals("forWhatToDo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UpgradeRealmProxyInterface) obj).realmSet$forWhatToDo(null);
                } else {
                    ((UpgradeRealmProxyInterface) obj).realmSet$forWhatToDo((String) reader.nextString());
                }
            } else if (name.equals("cost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
                } else {
                    ((UpgradeRealmProxyInterface) obj).realmSet$cost((int) reader.nextInt());
                }
            } else if (name.equals("whatDo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'whatDo' to null.");
                } else {
                    ((UpgradeRealmProxyInterface) obj).realmSet$whatDo((int) reader.nextInt());
                }
            } else if (name.equals("nameOfImg")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UpgradeRealmProxyInterface) obj).realmSet$nameOfImg(null);
                } else {
                    ((UpgradeRealmProxyInterface) obj).realmSet$nameOfImg((String) reader.nextString());
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

    public static com.companybest.ondra.engineerclicker.Models.Upgrade copyOrUpdate(Realm realm, com.companybest.ondra.engineerclicker.Models.Upgrade object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.companybest.ondra.engineerclicker.Models.Upgrade) cachedRealmObject;
        } else {
            com.companybest.ondra.engineerclicker.Models.Upgrade realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((UpgradeRealmProxyInterface) object).realmGet$name();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Upgrade.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.UpgradeRealmProxy();
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

    public static com.companybest.ondra.engineerclicker.Models.Upgrade copy(Realm realm, com.companybest.ondra.engineerclicker.Models.Upgrade newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.companybest.ondra.engineerclicker.Models.Upgrade) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.companybest.ondra.engineerclicker.Models.Upgrade realmObject = realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.Upgrade.class, ((UpgradeRealmProxyInterface) newObject).realmGet$name(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((UpgradeRealmProxyInterface) realmObject).realmSet$nameOfMachinetoGive(((UpgradeRealmProxyInterface) newObject).realmGet$nameOfMachinetoGive());
            ((UpgradeRealmProxyInterface) realmObject).realmSet$nameOfMaterialGive(((UpgradeRealmProxyInterface) newObject).realmGet$nameOfMaterialGive());
            ((UpgradeRealmProxyInterface) realmObject).realmSet$forWhatToDo(((UpgradeRealmProxyInterface) newObject).realmGet$forWhatToDo());
            ((UpgradeRealmProxyInterface) realmObject).realmSet$cost(((UpgradeRealmProxyInterface) newObject).realmGet$cost());
            ((UpgradeRealmProxyInterface) realmObject).realmSet$whatDo(((UpgradeRealmProxyInterface) newObject).realmGet$whatDo());
            ((UpgradeRealmProxyInterface) realmObject).realmSet$nameOfImg(((UpgradeRealmProxyInterface) newObject).realmGet$nameOfImg());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.companybest.ondra.engineerclicker.Models.Upgrade object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        long tableNativePtr = table.getNativeTablePointer();
        UpgradeColumnInfo columnInfo = (UpgradeColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((UpgradeRealmProxyInterface) object).realmGet$name();
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
        String realmGet$nameOfMachinetoGive = ((UpgradeRealmProxyInterface)object).realmGet$nameOfMachinetoGive();
        if (realmGet$nameOfMachinetoGive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfMachinetoGiveIndex, rowIndex, realmGet$nameOfMachinetoGive, false);
        }
        String realmGet$nameOfMaterialGive = ((UpgradeRealmProxyInterface)object).realmGet$nameOfMaterialGive();
        if (realmGet$nameOfMaterialGive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfMaterialGiveIndex, rowIndex, realmGet$nameOfMaterialGive, false);
        }
        String realmGet$forWhatToDo = ((UpgradeRealmProxyInterface)object).realmGet$forWhatToDo();
        if (realmGet$forWhatToDo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.forWhatToDoIndex, rowIndex, realmGet$forWhatToDo, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((UpgradeRealmProxyInterface)object).realmGet$cost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.whatDoIndex, rowIndex, ((UpgradeRealmProxyInterface)object).realmGet$whatDo(), false);
        String realmGet$nameOfImg = ((UpgradeRealmProxyInterface)object).realmGet$nameOfImg();
        if (realmGet$nameOfImg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfImgIndex, rowIndex, realmGet$nameOfImg, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        long tableNativePtr = table.getNativeTablePointer();
        UpgradeColumnInfo columnInfo = (UpgradeColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.companybest.ondra.engineerclicker.Models.Upgrade object = null;
        while (objects.hasNext()) {
            object = (com.companybest.ondra.engineerclicker.Models.Upgrade) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((UpgradeRealmProxyInterface) object).realmGet$name();
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
                String realmGet$nameOfMachinetoGive = ((UpgradeRealmProxyInterface)object).realmGet$nameOfMachinetoGive();
                if (realmGet$nameOfMachinetoGive != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfMachinetoGiveIndex, rowIndex, realmGet$nameOfMachinetoGive, false);
                }
                String realmGet$nameOfMaterialGive = ((UpgradeRealmProxyInterface)object).realmGet$nameOfMaterialGive();
                if (realmGet$nameOfMaterialGive != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfMaterialGiveIndex, rowIndex, realmGet$nameOfMaterialGive, false);
                }
                String realmGet$forWhatToDo = ((UpgradeRealmProxyInterface)object).realmGet$forWhatToDo();
                if (realmGet$forWhatToDo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.forWhatToDoIndex, rowIndex, realmGet$forWhatToDo, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((UpgradeRealmProxyInterface)object).realmGet$cost(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.whatDoIndex, rowIndex, ((UpgradeRealmProxyInterface)object).realmGet$whatDo(), false);
                String realmGet$nameOfImg = ((UpgradeRealmProxyInterface)object).realmGet$nameOfImg();
                if (realmGet$nameOfImg != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfImgIndex, rowIndex, realmGet$nameOfImg, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.companybest.ondra.engineerclicker.Models.Upgrade object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        long tableNativePtr = table.getNativeTablePointer();
        UpgradeColumnInfo columnInfo = (UpgradeColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((UpgradeRealmProxyInterface) object).realmGet$name();
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
        String realmGet$nameOfMachinetoGive = ((UpgradeRealmProxyInterface)object).realmGet$nameOfMachinetoGive();
        if (realmGet$nameOfMachinetoGive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfMachinetoGiveIndex, rowIndex, realmGet$nameOfMachinetoGive, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameOfMachinetoGiveIndex, rowIndex, false);
        }
        String realmGet$nameOfMaterialGive = ((UpgradeRealmProxyInterface)object).realmGet$nameOfMaterialGive();
        if (realmGet$nameOfMaterialGive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfMaterialGiveIndex, rowIndex, realmGet$nameOfMaterialGive, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameOfMaterialGiveIndex, rowIndex, false);
        }
        String realmGet$forWhatToDo = ((UpgradeRealmProxyInterface)object).realmGet$forWhatToDo();
        if (realmGet$forWhatToDo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.forWhatToDoIndex, rowIndex, realmGet$forWhatToDo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.forWhatToDoIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((UpgradeRealmProxyInterface)object).realmGet$cost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.whatDoIndex, rowIndex, ((UpgradeRealmProxyInterface)object).realmGet$whatDo(), false);
        String realmGet$nameOfImg = ((UpgradeRealmProxyInterface)object).realmGet$nameOfImg();
        if (realmGet$nameOfImg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfImgIndex, rowIndex, realmGet$nameOfImg, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameOfImgIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        long tableNativePtr = table.getNativeTablePointer();
        UpgradeColumnInfo columnInfo = (UpgradeColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.companybest.ondra.engineerclicker.Models.Upgrade object = null;
        while (objects.hasNext()) {
            object = (com.companybest.ondra.engineerclicker.Models.Upgrade) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((UpgradeRealmProxyInterface) object).realmGet$name();
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
                String realmGet$nameOfMachinetoGive = ((UpgradeRealmProxyInterface)object).realmGet$nameOfMachinetoGive();
                if (realmGet$nameOfMachinetoGive != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfMachinetoGiveIndex, rowIndex, realmGet$nameOfMachinetoGive, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameOfMachinetoGiveIndex, rowIndex, false);
                }
                String realmGet$nameOfMaterialGive = ((UpgradeRealmProxyInterface)object).realmGet$nameOfMaterialGive();
                if (realmGet$nameOfMaterialGive != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfMaterialGiveIndex, rowIndex, realmGet$nameOfMaterialGive, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameOfMaterialGiveIndex, rowIndex, false);
                }
                String realmGet$forWhatToDo = ((UpgradeRealmProxyInterface)object).realmGet$forWhatToDo();
                if (realmGet$forWhatToDo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.forWhatToDoIndex, rowIndex, realmGet$forWhatToDo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.forWhatToDoIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((UpgradeRealmProxyInterface)object).realmGet$cost(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.whatDoIndex, rowIndex, ((UpgradeRealmProxyInterface)object).realmGet$whatDo(), false);
                String realmGet$nameOfImg = ((UpgradeRealmProxyInterface)object).realmGet$nameOfImg();
                if (realmGet$nameOfImg != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfImgIndex, rowIndex, realmGet$nameOfImg, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameOfImgIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.companybest.ondra.engineerclicker.Models.Upgrade createDetachedCopy(com.companybest.ondra.engineerclicker.Models.Upgrade realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.companybest.ondra.engineerclicker.Models.Upgrade unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.companybest.ondra.engineerclicker.Models.Upgrade)cachedObject.object;
            } else {
                unmanagedObject = (com.companybest.ondra.engineerclicker.Models.Upgrade)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.companybest.ondra.engineerclicker.Models.Upgrade();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((UpgradeRealmProxyInterface) unmanagedObject).realmSet$name(((UpgradeRealmProxyInterface) realmObject).realmGet$name());
        ((UpgradeRealmProxyInterface) unmanagedObject).realmSet$nameOfMachinetoGive(((UpgradeRealmProxyInterface) realmObject).realmGet$nameOfMachinetoGive());
        ((UpgradeRealmProxyInterface) unmanagedObject).realmSet$nameOfMaterialGive(((UpgradeRealmProxyInterface) realmObject).realmGet$nameOfMaterialGive());
        ((UpgradeRealmProxyInterface) unmanagedObject).realmSet$forWhatToDo(((UpgradeRealmProxyInterface) realmObject).realmGet$forWhatToDo());
        ((UpgradeRealmProxyInterface) unmanagedObject).realmSet$cost(((UpgradeRealmProxyInterface) realmObject).realmGet$cost());
        ((UpgradeRealmProxyInterface) unmanagedObject).realmSet$whatDo(((UpgradeRealmProxyInterface) realmObject).realmGet$whatDo());
        ((UpgradeRealmProxyInterface) unmanagedObject).realmSet$nameOfImg(((UpgradeRealmProxyInterface) realmObject).realmGet$nameOfImg());
        return unmanagedObject;
    }

    static com.companybest.ondra.engineerclicker.Models.Upgrade update(Realm realm, com.companybest.ondra.engineerclicker.Models.Upgrade realmObject, com.companybest.ondra.engineerclicker.Models.Upgrade newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((UpgradeRealmProxyInterface) realmObject).realmSet$nameOfMachinetoGive(((UpgradeRealmProxyInterface) newObject).realmGet$nameOfMachinetoGive());
        ((UpgradeRealmProxyInterface) realmObject).realmSet$nameOfMaterialGive(((UpgradeRealmProxyInterface) newObject).realmGet$nameOfMaterialGive());
        ((UpgradeRealmProxyInterface) realmObject).realmSet$forWhatToDo(((UpgradeRealmProxyInterface) newObject).realmGet$forWhatToDo());
        ((UpgradeRealmProxyInterface) realmObject).realmSet$cost(((UpgradeRealmProxyInterface) newObject).realmGet$cost());
        ((UpgradeRealmProxyInterface) realmObject).realmSet$whatDo(((UpgradeRealmProxyInterface) newObject).realmGet$whatDo());
        ((UpgradeRealmProxyInterface) realmObject).realmSet$nameOfImg(((UpgradeRealmProxyInterface) newObject).realmGet$nameOfImg());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Upgrade = [");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameOfMachinetoGive:");
        stringBuilder.append(realmGet$nameOfMachinetoGive() != null ? realmGet$nameOfMachinetoGive() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameOfMaterialGive:");
        stringBuilder.append(realmGet$nameOfMaterialGive() != null ? realmGet$nameOfMaterialGive() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{forWhatToDo:");
        stringBuilder.append(realmGet$forWhatToDo() != null ? realmGet$forWhatToDo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cost:");
        stringBuilder.append(realmGet$cost());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{whatDo:");
        stringBuilder.append(realmGet$whatDo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameOfImg:");
        stringBuilder.append(realmGet$nameOfImg() != null ? realmGet$nameOfImg() : "null");
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
        UpgradeRealmProxy aUpgrade = (UpgradeRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUpgrade.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUpgrade.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUpgrade.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
