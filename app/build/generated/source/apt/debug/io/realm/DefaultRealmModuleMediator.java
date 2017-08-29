package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.companybest.ondra.engineerclicker.Models.Machine.class);
        modelClasses.add(com.companybest.ondra.engineerclicker.Models.Material.class);
        modelClasses.add(com.companybest.ondra.engineerclicker.Models.BasicWorker.class);
        modelClasses.add(com.companybest.ondra.engineerclicker.Models.User.class);
        modelClasses.add(com.companybest.ondra.engineerclicker.Models.Upgrade.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return io.realm.MachineRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return io.realm.MaterialRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return io.realm.BasicWorkerRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return io.realm.UserRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return io.realm.UpgradeRealmProxy.initTable(sharedRealm);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return io.realm.MachineRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return io.realm.MaterialRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return io.realm.BasicWorkerRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return io.realm.UserRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return io.realm.UpgradeRealmProxy.createRealmObjectSchema(realmSchema);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return io.realm.MachineRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return io.realm.MaterialRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return io.realm.BasicWorkerRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return io.realm.UserRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return io.realm.UpgradeRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return io.realm.MachineRealmProxy.getFieldNames();
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return io.realm.MaterialRealmProxy.getFieldNames();
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return io.realm.BasicWorkerRealmProxy.getFieldNames();
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return io.realm.UserRealmProxy.getFieldNames();
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return io.realm.UpgradeRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return io.realm.MachineRealmProxy.getTableName();
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return io.realm.MaterialRealmProxy.getTableName();
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return io.realm.BasicWorkerRealmProxy.getTableName();
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return io.realm.UserRealmProxy.getTableName();
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return io.realm.UpgradeRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
                return clazz.cast(new io.realm.MachineRealmProxy());
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
                return clazz.cast(new io.realm.MaterialRealmProxy());
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
                return clazz.cast(new io.realm.BasicWorkerRealmProxy());
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
                return clazz.cast(new io.realm.UserRealmProxy());
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
                return clazz.cast(new io.realm.UpgradeRealmProxy());
            } else {
                throw getMissingProxyClassException(clazz);
            }
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return clazz.cast(io.realm.MachineRealmProxy.copyOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Machine) obj, update, cache));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return clazz.cast(io.realm.MaterialRealmProxy.copyOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Material) obj, update, cache));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return clazz.cast(io.realm.BasicWorkerRealmProxy.copyOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.BasicWorker) obj, update, cache));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.copyOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.User) obj, update, cache));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return clazz.cast(io.realm.UpgradeRealmProxy.copyOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Upgrade) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            io.realm.MachineRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.Machine) object, cache);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            io.realm.MaterialRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.Material) object, cache);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            io.realm.BasicWorkerRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.BasicWorker) object, cache);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            io.realm.UserRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.User) object, cache);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            io.realm.UpgradeRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.Upgrade) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
                io.realm.MachineRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.Machine) object, cache);
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
                io.realm.MaterialRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.Material) object, cache);
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
                io.realm.BasicWorkerRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.BasicWorker) object, cache);
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
                io.realm.UserRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.User) object, cache);
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
                io.realm.UpgradeRealmProxy.insert(realm, (com.companybest.ondra.engineerclicker.Models.Upgrade) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
                    io.realm.MachineRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
                    io.realm.MaterialRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
                    io.realm.BasicWorkerRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
                    io.realm.UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
                    io.realm.UpgradeRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            io.realm.MachineRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Machine) obj, cache);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            io.realm.MaterialRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Material) obj, cache);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            io.realm.BasicWorkerRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.BasicWorker) obj, cache);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            io.realm.UserRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.User) obj, cache);
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            io.realm.UpgradeRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Upgrade) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
                io.realm.MachineRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Machine) object, cache);
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
                io.realm.MaterialRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Material) object, cache);
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
                io.realm.BasicWorkerRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.BasicWorker) object, cache);
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
                io.realm.UserRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.User) object, cache);
            } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
                io.realm.UpgradeRealmProxy.insertOrUpdate(realm, (com.companybest.ondra.engineerclicker.Models.Upgrade) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
                    io.realm.MachineRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
                    io.realm.MaterialRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
                    io.realm.BasicWorkerRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
                    io.realm.UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
                    io.realm.UpgradeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return clazz.cast(io.realm.MachineRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return clazz.cast(io.realm.MaterialRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return clazz.cast(io.realm.BasicWorkerRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return clazz.cast(io.realm.UpgradeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return clazz.cast(io.realm.MachineRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return clazz.cast(io.realm.MaterialRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return clazz.cast(io.realm.BasicWorkerRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return clazz.cast(io.realm.UpgradeRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Machine.class)) {
            return clazz.cast(io.realm.MachineRealmProxy.createDetachedCopy((com.companybest.ondra.engineerclicker.Models.Machine) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Material.class)) {
            return clazz.cast(io.realm.MaterialRealmProxy.createDetachedCopy((com.companybest.ondra.engineerclicker.Models.Material) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.BasicWorker.class)) {
            return clazz.cast(io.realm.BasicWorkerRealmProxy.createDetachedCopy((com.companybest.ondra.engineerclicker.Models.BasicWorker) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createDetachedCopy((com.companybest.ondra.engineerclicker.Models.User) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.companybest.ondra.engineerclicker.Models.Upgrade.class)) {
            return clazz.cast(io.realm.UpgradeRealmProxy.createDetachedCopy((com.companybest.ondra.engineerclicker.Models.Upgrade) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
