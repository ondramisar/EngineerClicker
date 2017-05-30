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

public class MachineRealmProxy extends com.companybest.ondra.engineerclicker.Models.Machines.Machine
    implements RealmObjectProxy, MachineRealmProxyInterface {

    static final class MachineColumnInfo extends ColumnInfo
        implements Cloneable {

        public long nameIndex;
        public long numberOfIndex;
        public long numberOfWorkersOnMachineIndex;
        public long costIndex;
        public long maxTimerOfMachineIndex;
        public long timerOfMachineIndex;
        public long expGiveIndex;
        public long nameOfMaterialIndex;
        public long nameOfNeededMaterialIndex;
        public long nameOfImageIndex;

        MachineColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(10);
            this.nameIndex = getValidColumnIndex(path, table, "Machine", "name");
            indicesMap.put("name", this.nameIndex);
            this.numberOfIndex = getValidColumnIndex(path, table, "Machine", "numberOf");
            indicesMap.put("numberOf", this.numberOfIndex);
            this.numberOfWorkersOnMachineIndex = getValidColumnIndex(path, table, "Machine", "numberOfWorkersOnMachine");
            indicesMap.put("numberOfWorkersOnMachine", this.numberOfWorkersOnMachineIndex);
            this.costIndex = getValidColumnIndex(path, table, "Machine", "cost");
            indicesMap.put("cost", this.costIndex);
            this.maxTimerOfMachineIndex = getValidColumnIndex(path, table, "Machine", "maxTimerOfMachine");
            indicesMap.put("maxTimerOfMachine", this.maxTimerOfMachineIndex);
            this.timerOfMachineIndex = getValidColumnIndex(path, table, "Machine", "timerOfMachine");
            indicesMap.put("timerOfMachine", this.timerOfMachineIndex);
            this.expGiveIndex = getValidColumnIndex(path, table, "Machine", "expGive");
            indicesMap.put("expGive", this.expGiveIndex);
            this.nameOfMaterialIndex = getValidColumnIndex(path, table, "Machine", "nameOfMaterial");
            indicesMap.put("nameOfMaterial", this.nameOfMaterialIndex);
            this.nameOfNeededMaterialIndex = getValidColumnIndex(path, table, "Machine", "nameOfNeededMaterial");
            indicesMap.put("nameOfNeededMaterial", this.nameOfNeededMaterialIndex);
            this.nameOfImageIndex = getValidColumnIndex(path, table, "Machine", "nameOfImage");
            indicesMap.put("nameOfImage", this.nameOfImageIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final MachineColumnInfo otherInfo = (MachineColumnInfo) other;
            this.nameIndex = otherInfo.nameIndex;
            this.numberOfIndex = otherInfo.numberOfIndex;
            this.numberOfWorkersOnMachineIndex = otherInfo.numberOfWorkersOnMachineIndex;
            this.costIndex = otherInfo.costIndex;
            this.maxTimerOfMachineIndex = otherInfo.maxTimerOfMachineIndex;
            this.timerOfMachineIndex = otherInfo.timerOfMachineIndex;
            this.expGiveIndex = otherInfo.expGiveIndex;
            this.nameOfMaterialIndex = otherInfo.nameOfMaterialIndex;
            this.nameOfNeededMaterialIndex = otherInfo.nameOfNeededMaterialIndex;
            this.nameOfImageIndex = otherInfo.nameOfImageIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final MachineColumnInfo clone() {
            return (MachineColumnInfo) super.clone();
        }

    }
    private MachineColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("numberOf");
        fieldNames.add("numberOfWorkersOnMachine");
        fieldNames.add("cost");
        fieldNames.add("maxTimerOfMachine");
        fieldNames.add("timerOfMachine");
        fieldNames.add("expGive");
        fieldNames.add("nameOfMaterial");
        fieldNames.add("nameOfNeededMaterial");
        fieldNames.add("nameOfImage");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MachineRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MachineColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class, this);
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
    public int realmGet$numberOf() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.numberOfIndex);
    }

    public void realmSet$numberOf(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.numberOfIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.numberOfIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$numberOfWorkersOnMachine() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.numberOfWorkersOnMachineIndex);
    }

    public void realmSet$numberOfWorkersOnMachine(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.numberOfWorkersOnMachineIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.numberOfWorkersOnMachineIndex, value);
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
    public int realmGet$maxTimerOfMachine() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxTimerOfMachineIndex);
    }

    public void realmSet$maxTimerOfMachine(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.maxTimerOfMachineIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.maxTimerOfMachineIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$timerOfMachine() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.timerOfMachineIndex);
    }

    public void realmSet$timerOfMachine(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timerOfMachineIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timerOfMachineIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$expGive() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.expGiveIndex);
    }

    public void realmSet$expGive(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.expGiveIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.expGiveIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$nameOfMaterial() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameOfMaterialIndex);
    }

    public void realmSet$nameOfMaterial(String value) {
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
                row.getTable().setNull(columnInfo.nameOfMaterialIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameOfMaterialIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameOfMaterialIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameOfMaterialIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$nameOfNeededMaterial() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameOfNeededMaterialIndex);
    }

    public void realmSet$nameOfNeededMaterial(String value) {
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
                row.getTable().setNull(columnInfo.nameOfNeededMaterialIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameOfNeededMaterialIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameOfNeededMaterialIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameOfNeededMaterialIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$nameOfImage() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameOfImageIndex);
    }

    public void realmSet$nameOfImage(String value) {
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
                row.getTable().setNull(columnInfo.nameOfImageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameOfImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameOfImageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameOfImageIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Machine")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Machine");
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("numberOf", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("numberOfWorkersOnMachine", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cost", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("maxTimerOfMachine", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("timerOfMachine", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("expGive", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("nameOfMaterial", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("nameOfNeededMaterial", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("nameOfImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Machine");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Machine")) {
            Table table = sharedRealm.getTable("class_Machine");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "numberOf", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "numberOfWorkersOnMachine", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cost", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "maxTimerOfMachine", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "timerOfMachine", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "expGive", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "nameOfMaterial", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "nameOfNeededMaterial", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "nameOfImage", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("name"));
            table.setPrimaryKey("name");
            return table;
        }
        return sharedRealm.getTable("class_Machine");
    }

    public static MachineColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Machine")) {
            Table table = sharedRealm.getTable("class_Machine");
            final long columnCount = table.getColumnCount();
            if (columnCount != 10) {
                if (columnCount < 10) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 10 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 10 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 10 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final MachineColumnInfo columnInfo = new MachineColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("numberOf")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numberOf' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("numberOf") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'numberOf' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.numberOfIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numberOf' does support null values in the existing Realm file. Use corresponding boxed type for field 'numberOf' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("numberOfWorkersOnMachine")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numberOfWorkersOnMachine' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("numberOfWorkersOnMachine") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'numberOfWorkersOnMachine' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.numberOfWorkersOnMachineIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numberOfWorkersOnMachine' does support null values in the existing Realm file. Use corresponding boxed type for field 'numberOfWorkersOnMachine' or migrate using RealmObjectSchema.setNullable().");
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
            if (!columnTypes.containsKey("maxTimerOfMachine")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxTimerOfMachine' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("maxTimerOfMachine") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxTimerOfMachine' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.maxTimerOfMachineIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxTimerOfMachine' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxTimerOfMachine' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("timerOfMachine")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'timerOfMachine' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("timerOfMachine") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'timerOfMachine' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.timerOfMachineIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'timerOfMachine' does support null values in the existing Realm file. Use corresponding boxed type for field 'timerOfMachine' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("expGive")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'expGive' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("expGive") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'expGive' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.expGiveIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'expGive' does support null values in the existing Realm file. Use corresponding boxed type for field 'expGive' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("nameOfMaterial")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameOfMaterial' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nameOfMaterial") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameOfMaterial' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameOfMaterialIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameOfMaterial' is required. Either set @Required to field 'nameOfMaterial' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("nameOfNeededMaterial")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameOfNeededMaterial' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nameOfNeededMaterial") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameOfNeededMaterial' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameOfNeededMaterialIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameOfNeededMaterial' is required. Either set @Required to field 'nameOfNeededMaterial' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("nameOfImage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameOfImage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nameOfImage") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameOfImage' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameOfImageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameOfImage' is required. Either set @Required to field 'nameOfImage' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Machine' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Machine";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.companybest.ondra.engineerclicker.Models.Machines.Machine createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.companybest.ondra.engineerclicker.Models.Machines.Machine obj = null;
        if (update) {
            Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MachineRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("name")) {
                if (json.isNull("name")) {
                    obj = (io.realm.MachineRealmProxy) realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MachineRealmProxy) realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class, json.getString("name"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'name'.");
            }
        }
        if (json.has("numberOf")) {
            if (json.isNull("numberOf")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'numberOf' to null.");
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$numberOf((int) json.getInt("numberOf"));
            }
        }
        if (json.has("numberOfWorkersOnMachine")) {
            if (json.isNull("numberOfWorkersOnMachine")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'numberOfWorkersOnMachine' to null.");
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$numberOfWorkersOnMachine((int) json.getInt("numberOfWorkersOnMachine"));
            }
        }
        if (json.has("cost")) {
            if (json.isNull("cost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$cost((int) json.getInt("cost"));
            }
        }
        if (json.has("maxTimerOfMachine")) {
            if (json.isNull("maxTimerOfMachine")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxTimerOfMachine' to null.");
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$maxTimerOfMachine((int) json.getInt("maxTimerOfMachine"));
            }
        }
        if (json.has("timerOfMachine")) {
            if (json.isNull("timerOfMachine")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timerOfMachine' to null.");
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$timerOfMachine((int) json.getInt("timerOfMachine"));
            }
        }
        if (json.has("expGive")) {
            if (json.isNull("expGive")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'expGive' to null.");
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$expGive((int) json.getInt("expGive"));
            }
        }
        if (json.has("nameOfMaterial")) {
            if (json.isNull("nameOfMaterial")) {
                ((MachineRealmProxyInterface) obj).realmSet$nameOfMaterial(null);
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$nameOfMaterial((String) json.getString("nameOfMaterial"));
            }
        }
        if (json.has("nameOfNeededMaterial")) {
            if (json.isNull("nameOfNeededMaterial")) {
                ((MachineRealmProxyInterface) obj).realmSet$nameOfNeededMaterial(null);
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$nameOfNeededMaterial((String) json.getString("nameOfNeededMaterial"));
            }
        }
        if (json.has("nameOfImage")) {
            if (json.isNull("nameOfImage")) {
                ((MachineRealmProxyInterface) obj).realmSet$nameOfImage(null);
            } else {
                ((MachineRealmProxyInterface) obj).realmSet$nameOfImage((String) json.getString("nameOfImage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.companybest.ondra.engineerclicker.Models.Machines.Machine createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.companybest.ondra.engineerclicker.Models.Machines.Machine obj = new com.companybest.ondra.engineerclicker.Models.Machines.Machine();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MachineRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("numberOf")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'numberOf' to null.");
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$numberOf((int) reader.nextInt());
                }
            } else if (name.equals("numberOfWorkersOnMachine")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'numberOfWorkersOnMachine' to null.");
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$numberOfWorkersOnMachine((int) reader.nextInt());
                }
            } else if (name.equals("cost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$cost((int) reader.nextInt());
                }
            } else if (name.equals("maxTimerOfMachine")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxTimerOfMachine' to null.");
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$maxTimerOfMachine((int) reader.nextInt());
                }
            } else if (name.equals("timerOfMachine")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timerOfMachine' to null.");
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$timerOfMachine((int) reader.nextInt());
                }
            } else if (name.equals("expGive")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'expGive' to null.");
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$expGive((int) reader.nextInt());
                }
            } else if (name.equals("nameOfMaterial")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MachineRealmProxyInterface) obj).realmSet$nameOfMaterial(null);
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$nameOfMaterial((String) reader.nextString());
                }
            } else if (name.equals("nameOfNeededMaterial")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MachineRealmProxyInterface) obj).realmSet$nameOfNeededMaterial(null);
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$nameOfNeededMaterial((String) reader.nextString());
                }
            } else if (name.equals("nameOfImage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MachineRealmProxyInterface) obj).realmSet$nameOfImage(null);
                } else {
                    ((MachineRealmProxyInterface) obj).realmSet$nameOfImage((String) reader.nextString());
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

    public static com.companybest.ondra.engineerclicker.Models.Machines.Machine copyOrUpdate(Realm realm, com.companybest.ondra.engineerclicker.Models.Machines.Machine object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.companybest.ondra.engineerclicker.Models.Machines.Machine) cachedRealmObject;
        } else {
            com.companybest.ondra.engineerclicker.Models.Machines.Machine realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((MachineRealmProxyInterface) object).realmGet$name();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MachineRealmProxy();
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

    public static com.companybest.ondra.engineerclicker.Models.Machines.Machine copy(Realm realm, com.companybest.ondra.engineerclicker.Models.Machines.Machine newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.companybest.ondra.engineerclicker.Models.Machines.Machine) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.companybest.ondra.engineerclicker.Models.Machines.Machine realmObject = realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class, ((MachineRealmProxyInterface) newObject).realmGet$name(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MachineRealmProxyInterface) realmObject).realmSet$numberOf(((MachineRealmProxyInterface) newObject).realmGet$numberOf());
            ((MachineRealmProxyInterface) realmObject).realmSet$numberOfWorkersOnMachine(((MachineRealmProxyInterface) newObject).realmGet$numberOfWorkersOnMachine());
            ((MachineRealmProxyInterface) realmObject).realmSet$cost(((MachineRealmProxyInterface) newObject).realmGet$cost());
            ((MachineRealmProxyInterface) realmObject).realmSet$maxTimerOfMachine(((MachineRealmProxyInterface) newObject).realmGet$maxTimerOfMachine());
            ((MachineRealmProxyInterface) realmObject).realmSet$timerOfMachine(((MachineRealmProxyInterface) newObject).realmGet$timerOfMachine());
            ((MachineRealmProxyInterface) realmObject).realmSet$expGive(((MachineRealmProxyInterface) newObject).realmGet$expGive());
            ((MachineRealmProxyInterface) realmObject).realmSet$nameOfMaterial(((MachineRealmProxyInterface) newObject).realmGet$nameOfMaterial());
            ((MachineRealmProxyInterface) realmObject).realmSet$nameOfNeededMaterial(((MachineRealmProxyInterface) newObject).realmGet$nameOfNeededMaterial());
            ((MachineRealmProxyInterface) realmObject).realmSet$nameOfImage(((MachineRealmProxyInterface) newObject).realmGet$nameOfImage());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.companybest.ondra.engineerclicker.Models.Machines.Machine object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
        long tableNativePtr = table.getNativeTablePointer();
        MachineColumnInfo columnInfo = (MachineColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((MachineRealmProxyInterface) object).realmGet$name();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.numberOfIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$numberOf(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.numberOfWorkersOnMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$numberOfWorkersOnMachine(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$cost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxTimerOfMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$maxTimerOfMachine(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timerOfMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$timerOfMachine(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.expGiveIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$expGive(), false);
        String realmGet$nameOfMaterial = ((MachineRealmProxyInterface)object).realmGet$nameOfMaterial();
        if (realmGet$nameOfMaterial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfMaterialIndex, rowIndex, realmGet$nameOfMaterial, false);
        }
        String realmGet$nameOfNeededMaterial = ((MachineRealmProxyInterface)object).realmGet$nameOfNeededMaterial();
        if (realmGet$nameOfNeededMaterial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfNeededMaterialIndex, rowIndex, realmGet$nameOfNeededMaterial, false);
        }
        String realmGet$nameOfImage = ((MachineRealmProxyInterface)object).realmGet$nameOfImage();
        if (realmGet$nameOfImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfImageIndex, rowIndex, realmGet$nameOfImage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
        long tableNativePtr = table.getNativeTablePointer();
        MachineColumnInfo columnInfo = (MachineColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.companybest.ondra.engineerclicker.Models.Machines.Machine object = null;
        while (objects.hasNext()) {
            object = (com.companybest.ondra.engineerclicker.Models.Machines.Machine) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((MachineRealmProxyInterface) object).realmGet$name();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.numberOfIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$numberOf(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.numberOfWorkersOnMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$numberOfWorkersOnMachine(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$cost(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxTimerOfMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$maxTimerOfMachine(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.timerOfMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$timerOfMachine(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.expGiveIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$expGive(), false);
                String realmGet$nameOfMaterial = ((MachineRealmProxyInterface)object).realmGet$nameOfMaterial();
                if (realmGet$nameOfMaterial != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfMaterialIndex, rowIndex, realmGet$nameOfMaterial, false);
                }
                String realmGet$nameOfNeededMaterial = ((MachineRealmProxyInterface)object).realmGet$nameOfNeededMaterial();
                if (realmGet$nameOfNeededMaterial != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfNeededMaterialIndex, rowIndex, realmGet$nameOfNeededMaterial, false);
                }
                String realmGet$nameOfImage = ((MachineRealmProxyInterface)object).realmGet$nameOfImage();
                if (realmGet$nameOfImage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfImageIndex, rowIndex, realmGet$nameOfImage, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.companybest.ondra.engineerclicker.Models.Machines.Machine object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
        long tableNativePtr = table.getNativeTablePointer();
        MachineColumnInfo columnInfo = (MachineColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((MachineRealmProxyInterface) object).realmGet$name();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.numberOfIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$numberOf(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.numberOfWorkersOnMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$numberOfWorkersOnMachine(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$cost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxTimerOfMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$maxTimerOfMachine(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timerOfMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$timerOfMachine(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.expGiveIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$expGive(), false);
        String realmGet$nameOfMaterial = ((MachineRealmProxyInterface)object).realmGet$nameOfMaterial();
        if (realmGet$nameOfMaterial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfMaterialIndex, rowIndex, realmGet$nameOfMaterial, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameOfMaterialIndex, rowIndex, false);
        }
        String realmGet$nameOfNeededMaterial = ((MachineRealmProxyInterface)object).realmGet$nameOfNeededMaterial();
        if (realmGet$nameOfNeededMaterial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfNeededMaterialIndex, rowIndex, realmGet$nameOfNeededMaterial, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameOfNeededMaterialIndex, rowIndex, false);
        }
        String realmGet$nameOfImage = ((MachineRealmProxyInterface)object).realmGet$nameOfImage();
        if (realmGet$nameOfImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameOfImageIndex, rowIndex, realmGet$nameOfImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameOfImageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
        long tableNativePtr = table.getNativeTablePointer();
        MachineColumnInfo columnInfo = (MachineColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.Machines.Machine.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.companybest.ondra.engineerclicker.Models.Machines.Machine object = null;
        while (objects.hasNext()) {
            object = (com.companybest.ondra.engineerclicker.Models.Machines.Machine) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((MachineRealmProxyInterface) object).realmGet$name();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.numberOfIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$numberOf(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.numberOfWorkersOnMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$numberOfWorkersOnMachine(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$cost(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxTimerOfMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$maxTimerOfMachine(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.timerOfMachineIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$timerOfMachine(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.expGiveIndex, rowIndex, ((MachineRealmProxyInterface)object).realmGet$expGive(), false);
                String realmGet$nameOfMaterial = ((MachineRealmProxyInterface)object).realmGet$nameOfMaterial();
                if (realmGet$nameOfMaterial != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfMaterialIndex, rowIndex, realmGet$nameOfMaterial, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameOfMaterialIndex, rowIndex, false);
                }
                String realmGet$nameOfNeededMaterial = ((MachineRealmProxyInterface)object).realmGet$nameOfNeededMaterial();
                if (realmGet$nameOfNeededMaterial != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfNeededMaterialIndex, rowIndex, realmGet$nameOfNeededMaterial, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameOfNeededMaterialIndex, rowIndex, false);
                }
                String realmGet$nameOfImage = ((MachineRealmProxyInterface)object).realmGet$nameOfImage();
                if (realmGet$nameOfImage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameOfImageIndex, rowIndex, realmGet$nameOfImage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameOfImageIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.companybest.ondra.engineerclicker.Models.Machines.Machine createDetachedCopy(com.companybest.ondra.engineerclicker.Models.Machines.Machine realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.companybest.ondra.engineerclicker.Models.Machines.Machine unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.companybest.ondra.engineerclicker.Models.Machines.Machine)cachedObject.object;
            } else {
                unmanagedObject = (com.companybest.ondra.engineerclicker.Models.Machines.Machine)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.companybest.ondra.engineerclicker.Models.Machines.Machine();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$name(((MachineRealmProxyInterface) realmObject).realmGet$name());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$numberOf(((MachineRealmProxyInterface) realmObject).realmGet$numberOf());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$numberOfWorkersOnMachine(((MachineRealmProxyInterface) realmObject).realmGet$numberOfWorkersOnMachine());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$cost(((MachineRealmProxyInterface) realmObject).realmGet$cost());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$maxTimerOfMachine(((MachineRealmProxyInterface) realmObject).realmGet$maxTimerOfMachine());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$timerOfMachine(((MachineRealmProxyInterface) realmObject).realmGet$timerOfMachine());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$expGive(((MachineRealmProxyInterface) realmObject).realmGet$expGive());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$nameOfMaterial(((MachineRealmProxyInterface) realmObject).realmGet$nameOfMaterial());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$nameOfNeededMaterial(((MachineRealmProxyInterface) realmObject).realmGet$nameOfNeededMaterial());
        ((MachineRealmProxyInterface) unmanagedObject).realmSet$nameOfImage(((MachineRealmProxyInterface) realmObject).realmGet$nameOfImage());
        return unmanagedObject;
    }

    static com.companybest.ondra.engineerclicker.Models.Machines.Machine update(Realm realm, com.companybest.ondra.engineerclicker.Models.Machines.Machine realmObject, com.companybest.ondra.engineerclicker.Models.Machines.Machine newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MachineRealmProxyInterface) realmObject).realmSet$numberOf(((MachineRealmProxyInterface) newObject).realmGet$numberOf());
        ((MachineRealmProxyInterface) realmObject).realmSet$numberOfWorkersOnMachine(((MachineRealmProxyInterface) newObject).realmGet$numberOfWorkersOnMachine());
        ((MachineRealmProxyInterface) realmObject).realmSet$cost(((MachineRealmProxyInterface) newObject).realmGet$cost());
        ((MachineRealmProxyInterface) realmObject).realmSet$maxTimerOfMachine(((MachineRealmProxyInterface) newObject).realmGet$maxTimerOfMachine());
        ((MachineRealmProxyInterface) realmObject).realmSet$timerOfMachine(((MachineRealmProxyInterface) newObject).realmGet$timerOfMachine());
        ((MachineRealmProxyInterface) realmObject).realmSet$expGive(((MachineRealmProxyInterface) newObject).realmGet$expGive());
        ((MachineRealmProxyInterface) realmObject).realmSet$nameOfMaterial(((MachineRealmProxyInterface) newObject).realmGet$nameOfMaterial());
        ((MachineRealmProxyInterface) realmObject).realmSet$nameOfNeededMaterial(((MachineRealmProxyInterface) newObject).realmGet$nameOfNeededMaterial());
        ((MachineRealmProxyInterface) realmObject).realmSet$nameOfImage(((MachineRealmProxyInterface) newObject).realmGet$nameOfImage());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Machine = [");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberOf:");
        stringBuilder.append(realmGet$numberOf());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberOfWorkersOnMachine:");
        stringBuilder.append(realmGet$numberOfWorkersOnMachine());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cost:");
        stringBuilder.append(realmGet$cost());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxTimerOfMachine:");
        stringBuilder.append(realmGet$maxTimerOfMachine());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timerOfMachine:");
        stringBuilder.append(realmGet$timerOfMachine());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{expGive:");
        stringBuilder.append(realmGet$expGive());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameOfMaterial:");
        stringBuilder.append(realmGet$nameOfMaterial() != null ? realmGet$nameOfMaterial() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameOfNeededMaterial:");
        stringBuilder.append(realmGet$nameOfNeededMaterial() != null ? realmGet$nameOfNeededMaterial() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameOfImage:");
        stringBuilder.append(realmGet$nameOfImage() != null ? realmGet$nameOfImage() : "null");
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
        MachineRealmProxy aMachine = (MachineRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMachine.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMachine.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMachine.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
