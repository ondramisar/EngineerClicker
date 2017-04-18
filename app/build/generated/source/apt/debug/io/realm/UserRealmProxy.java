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
        public long coinsIndex;
        public long timeOutOfAppIndex;
        public long costIndex;

        UserColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.nameIndex = getValidColumnIndex(path, table, "User", "name");
            indicesMap.put("name", this.nameIndex);
            this.coinsIndex = getValidColumnIndex(path, table, "User", "coins");
            indicesMap.put("coins", this.coinsIndex);
            this.timeOutOfAppIndex = getValidColumnIndex(path, table, "User", "timeOutOfApp");
            indicesMap.put("timeOutOfApp", this.timeOutOfAppIndex);
            this.costIndex = getValidColumnIndex(path, table, "User", "cost");
            indicesMap.put("cost", this.costIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final UserColumnInfo otherInfo = (UserColumnInfo) other;
            this.nameIndex = otherInfo.nameIndex;
            this.coinsIndex = otherInfo.coinsIndex;
            this.timeOutOfAppIndex = otherInfo.timeOutOfAppIndex;
            this.costIndex = otherInfo.costIndex;

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
        fieldNames.add("coins");
        fieldNames.add("timeOutOfApp");
        fieldNames.add("cost");
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
    public float realmGet$timeOutOfApp() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.timeOutOfAppIndex);
    }

    public void realmSet$timeOutOfApp(float value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.timeOutOfAppIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.timeOutOfAppIndex, value);
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
        if (!realmSchema.contains("User")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("User");
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("coins", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("timeOutOfApp", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cost", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("User");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_User")) {
            Table table = sharedRealm.getTable("class_User");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.FLOAT, "coins", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.FLOAT, "timeOutOfApp", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cost", Table.NOT_NULLABLE);
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
            if (columnCount != 4) {
                if (columnCount < 4) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
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
            if (!columnTypes.containsKey("coins")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'coins' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("coins") != RealmFieldType.FLOAT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'float' for field 'coins' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.coinsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'coins' does support null values in the existing Realm file. Use corresponding boxed type for field 'coins' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("timeOutOfApp")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'timeOutOfApp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("timeOutOfApp") != RealmFieldType.FLOAT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'float' for field 'timeOutOfApp' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.timeOutOfAppIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'timeOutOfApp' does support null values in the existing Realm file. Use corresponding boxed type for field 'timeOutOfApp' or migrate using RealmObjectSchema.setNullable().");
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
        if (json.has("coins")) {
            if (json.isNull("coins")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'coins' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$coins((float) json.getDouble("coins"));
            }
        }
        if (json.has("timeOutOfApp")) {
            if (json.isNull("timeOutOfApp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timeOutOfApp' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$timeOutOfApp((float) json.getDouble("timeOutOfApp"));
            }
        }
        if (json.has("cost")) {
            if (json.isNull("cost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$cost((int) json.getInt("cost"));
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
            } else if (name.equals("coins")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'coins' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$coins((float) reader.nextDouble());
                }
            } else if (name.equals("timeOutOfApp")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timeOutOfApp' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$timeOutOfApp((float) reader.nextDouble());
                }
            } else if (name.equals("cost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$cost((int) reader.nextInt());
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
            ((UserRealmProxyInterface) realmObject).realmSet$coins(((UserRealmProxyInterface) newObject).realmGet$coins());
            ((UserRealmProxyInterface) realmObject).realmSet$timeOutOfApp(((UserRealmProxyInterface) newObject).realmGet$timeOutOfApp());
            ((UserRealmProxyInterface) realmObject).realmSet$cost(((UserRealmProxyInterface) newObject).realmGet$cost());
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
        Table.nativeSetFloat(tableNativePtr, columnInfo.coinsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$coins(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.timeOutOfAppIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$timeOutOfApp(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$cost(), false);
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
                Table.nativeSetFloat(tableNativePtr, columnInfo.coinsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$coins(), false);
                Table.nativeSetFloat(tableNativePtr, columnInfo.timeOutOfAppIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$timeOutOfApp(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$cost(), false);
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
        Table.nativeSetFloat(tableNativePtr, columnInfo.coinsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$coins(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.timeOutOfAppIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$timeOutOfApp(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$cost(), false);
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
                Table.nativeSetFloat(tableNativePtr, columnInfo.coinsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$coins(), false);
                Table.nativeSetFloat(tableNativePtr, columnInfo.timeOutOfAppIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$timeOutOfApp(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.costIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$cost(), false);
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
        ((UserRealmProxyInterface) unmanagedObject).realmSet$coins(((UserRealmProxyInterface) realmObject).realmGet$coins());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$timeOutOfApp(((UserRealmProxyInterface) realmObject).realmGet$timeOutOfApp());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$cost(((UserRealmProxyInterface) realmObject).realmGet$cost());
        return unmanagedObject;
    }

    static com.companybest.ondra.engineerclicker.Models.User update(Realm realm, com.companybest.ondra.engineerclicker.Models.User realmObject, com.companybest.ondra.engineerclicker.Models.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((UserRealmProxyInterface) realmObject).realmSet$coins(((UserRealmProxyInterface) newObject).realmGet$coins());
        ((UserRealmProxyInterface) realmObject).realmSet$timeOutOfApp(((UserRealmProxyInterface) newObject).realmGet$timeOutOfApp());
        ((UserRealmProxyInterface) realmObject).realmSet$cost(((UserRealmProxyInterface) newObject).realmGet$cost());
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
        stringBuilder.append("{coins:");
        stringBuilder.append(realmGet$coins());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timeOutOfApp:");
        stringBuilder.append(realmGet$timeOutOfApp());
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
