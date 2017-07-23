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

public class BasicWorkerRealmProxy extends com.companybest.ondra.engineerclicker.Models.BasicWorker
    implements RealmObjectProxy, BasicWorkerRealmProxyInterface {

    static final class BasicWorkerColumnInfo extends ColumnInfo
        implements Cloneable {

        public long nameIndex;
        public long numberOfIndex;
        public long costIndex;

        BasicWorkerColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(3);
            this.nameIndex = getValidColumnIndex(path, table, "BasicWorker", "name");
            indicesMap.put("name", this.nameIndex);
            this.numberOfIndex = getValidColumnIndex(path, table, "BasicWorker", "numberOf");
            indicesMap.put("numberOf", this.numberOfIndex);
            this.costIndex = getValidColumnIndex(path, table, "BasicWorker", "cost");
            indicesMap.put("cost", this.costIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final BasicWorkerColumnInfo otherInfo = (BasicWorkerColumnInfo) other;
            this.nameIndex = otherInfo.nameIndex;
            this.numberOfIndex = otherInfo.numberOfIndex;
            this.costIndex = otherInfo.costIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final BasicWorkerColumnInfo clone() {
            return (BasicWorkerColumnInfo) super.clone();
        }

    }
    private BasicWorkerColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("numberOf");
        fieldNames.add("cost");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    BasicWorkerRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BasicWorkerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.companybest.ondra.engineerclicker.Models.BasicWorker.class, this);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("BasicWorker")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("BasicWorker");
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("numberOf", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cost", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("BasicWorker");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_BasicWorker")) {
            Table table = sharedRealm.getTable("class_BasicWorker");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "numberOf", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cost", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("name"));
            table.setPrimaryKey("name");
            return table;
        }
        return sharedRealm.getTable("class_BasicWorker");
    }

    public static BasicWorkerColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_BasicWorker")) {
            Table table = sharedRealm.getTable("class_BasicWorker");
            final long columnCount = table.getColumnCount();
            if (columnCount != 3) {
                if (columnCount < 3) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final BasicWorkerColumnInfo columnInfo = new BasicWorkerColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("cost")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cost") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cost' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.costIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cost' does support null values in the existing Realm file. Use corresponding boxed type for field 'cost' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'BasicWorker' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_BasicWorker";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.companybest.ondra.engineerclicker.Models.BasicWorker createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.companybest.ondra.engineerclicker.Models.BasicWorker obj = null;
        if (update) {
            Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.BasicWorker.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BasicWorkerRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("name")) {
                if (json.isNull("name")) {
                    obj = (io.realm.BasicWorkerRealmProxy) realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.BasicWorker.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BasicWorkerRealmProxy) realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.BasicWorker.class, json.getString("name"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'name'.");
            }
        }
        if (json.has("numberOf")) {
            if (json.isNull("numberOf")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'numberOf' to null.");
            } else {
                ((BasicWorkerRealmProxyInterface) obj).realmSet$numberOf((int) json.getInt("numberOf"));
            }
        }
        if (json.has("cost")) {
            if (json.isNull("cost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
            } else {
                ((BasicWorkerRealmProxyInterface) obj).realmSet$cost((int) json.getInt("cost"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.companybest.ondra.engineerclicker.Models.BasicWorker createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.companybest.ondra.engineerclicker.Models.BasicWorker obj = new com.companybest.ondra.engineerclicker.Models.BasicWorker();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BasicWorkerRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((BasicWorkerRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("numberOf")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'numberOf' to null.");
                } else {
                    ((BasicWorkerRealmProxyInterface) obj).realmSet$numberOf((int) reader.nextInt());
                }
            } else if (name.equals("cost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
                } else {
                    ((BasicWorkerRealmProxyInterface) obj).realmSet$cost((int) reader.nextInt());
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

    public static com.companybest.ondra.engineerclicker.Models.BasicWorker copyOrUpdate(Realm realm, com.companybest.ondra.engineerclicker.Models.BasicWorker object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.companybest.ondra.engineerclicker.Models.BasicWorker) cachedRealmObject;
        } else {
            com.companybest.ondra.engineerclicker.Models.BasicWorker realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((BasicWorkerRealmProxyInterface) object).realmGet$name();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.BasicWorker.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.BasicWorkerRealmProxy();
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

    public static com.companybest.ondra.engineerclicker.Models.BasicWorker copy(Realm realm, com.companybest.ondra.engineerclicker.Models.BasicWorker newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.companybest.ondra.engineerclicker.Models.BasicWorker) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.companybest.ondra.engineerclicker.Models.BasicWorker realmObject = realm.createObjectInternal(com.companybest.ondra.engineerclicker.Models.BasicWorker.class, ((BasicWorkerRealmProxyInterface) newObject).realmGet$name(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((BasicWorkerRealmProxyInterface) realmObject).realmSet$numberOf(((BasicWorkerRealmProxyInterface) newObject).realmGet$numberOf());
            ((BasicWorkerRealmProxyInterface) realmObject).realmSet$cost(((BasicWorkerRealmProxyInterface) newObject).realmGet$cost());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.companybest.ondra.engineerclicker.Models.BasicWorker object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        long tableNativePtr = table.getNativeTablePointer();
        BasicWorkerColumnInfo columnInfo = (BasicWorkerColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BasicWorkerRealmProxyInterface) object).realmGet$name();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.numberOfIndex, rowIndex, ((BasicWorkerRealmProxyInterface)object).realmGet$numberOf(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((BasicWorkerRealmProxyInterface)object).realmGet$cost(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        long tableNativePtr = table.getNativeTablePointer();
        BasicWorkerColumnInfo columnInfo = (BasicWorkerColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.companybest.ondra.engineerclicker.Models.BasicWorker object = null;
        while (objects.hasNext()) {
            object = (com.companybest.ondra.engineerclicker.Models.BasicWorker) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BasicWorkerRealmProxyInterface) object).realmGet$name();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.numberOfIndex, rowIndex, ((BasicWorkerRealmProxyInterface)object).realmGet$numberOf(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((BasicWorkerRealmProxyInterface)object).realmGet$cost(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.companybest.ondra.engineerclicker.Models.BasicWorker object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        long tableNativePtr = table.getNativeTablePointer();
        BasicWorkerColumnInfo columnInfo = (BasicWorkerColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BasicWorkerRealmProxyInterface) object).realmGet$name();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.numberOfIndex, rowIndex, ((BasicWorkerRealmProxyInterface)object).realmGet$numberOf(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((BasicWorkerRealmProxyInterface)object).realmGet$cost(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        long tableNativePtr = table.getNativeTablePointer();
        BasicWorkerColumnInfo columnInfo = (BasicWorkerColumnInfo) realm.schema.getColumnInfo(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.companybest.ondra.engineerclicker.Models.BasicWorker object = null;
        while (objects.hasNext()) {
            object = (com.companybest.ondra.engineerclicker.Models.BasicWorker) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BasicWorkerRealmProxyInterface) object).realmGet$name();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.numberOfIndex, rowIndex, ((BasicWorkerRealmProxyInterface)object).realmGet$numberOf(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((BasicWorkerRealmProxyInterface)object).realmGet$cost(), false);
            }
        }
    }

    public static com.companybest.ondra.engineerclicker.Models.BasicWorker createDetachedCopy(com.companybest.ondra.engineerclicker.Models.BasicWorker realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.companybest.ondra.engineerclicker.Models.BasicWorker unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.companybest.ondra.engineerclicker.Models.BasicWorker)cachedObject.object;
            } else {
                unmanagedObject = (com.companybest.ondra.engineerclicker.Models.BasicWorker)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.companybest.ondra.engineerclicker.Models.BasicWorker();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((BasicWorkerRealmProxyInterface) unmanagedObject).realmSet$name(((BasicWorkerRealmProxyInterface) realmObject).realmGet$name());
        ((BasicWorkerRealmProxyInterface) unmanagedObject).realmSet$numberOf(((BasicWorkerRealmProxyInterface) realmObject).realmGet$numberOf());
        ((BasicWorkerRealmProxyInterface) unmanagedObject).realmSet$cost(((BasicWorkerRealmProxyInterface) realmObject).realmGet$cost());
        return unmanagedObject;
    }

    static com.companybest.ondra.engineerclicker.Models.BasicWorker update(Realm realm, com.companybest.ondra.engineerclicker.Models.BasicWorker realmObject, com.companybest.ondra.engineerclicker.Models.BasicWorker newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((BasicWorkerRealmProxyInterface) realmObject).realmSet$numberOf(((BasicWorkerRealmProxyInterface) newObject).realmGet$numberOf());
        ((BasicWorkerRealmProxyInterface) realmObject).realmSet$cost(((BasicWorkerRealmProxyInterface) newObject).realmGet$cost());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BasicWorker = [");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberOf:");
        stringBuilder.append(realmGet$numberOf());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cost:");
        stringBuilder.append(realmGet$cost());
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
        BasicWorkerRealmProxy aBasicWorker = (BasicWorkerRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBasicWorker.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBasicWorker.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBasicWorker.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
