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

public class FeedResponseRealmProxy extends me.anil.imageloader.repository.FeedResponse
    implements RealmObjectProxy, FeedResponseRealmProxyInterface {

    static final class FeedResponseColumnInfo extends ColumnInfo
        implements Cloneable {

        public long formatIndex;
        public long widthIndex;
        public long heightIndex;
        public long filenameIndex;
        public long idIndex;
        public long authorIndex;
        public long author_urlIndex;
        public long post_urlIndex;

        FeedResponseColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(8);
            this.formatIndex = getValidColumnIndex(path, table, "FeedResponse", "format");
            indicesMap.put("format", this.formatIndex);
            this.widthIndex = getValidColumnIndex(path, table, "FeedResponse", "width");
            indicesMap.put("width", this.widthIndex);
            this.heightIndex = getValidColumnIndex(path, table, "FeedResponse", "height");
            indicesMap.put("height", this.heightIndex);
            this.filenameIndex = getValidColumnIndex(path, table, "FeedResponse", "filename");
            indicesMap.put("filename", this.filenameIndex);
            this.idIndex = getValidColumnIndex(path, table, "FeedResponse", "id");
            indicesMap.put("id", this.idIndex);
            this.authorIndex = getValidColumnIndex(path, table, "FeedResponse", "author");
            indicesMap.put("author", this.authorIndex);
            this.author_urlIndex = getValidColumnIndex(path, table, "FeedResponse", "author_url");
            indicesMap.put("author_url", this.author_urlIndex);
            this.post_urlIndex = getValidColumnIndex(path, table, "FeedResponse", "post_url");
            indicesMap.put("post_url", this.post_urlIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final FeedResponseColumnInfo otherInfo = (FeedResponseColumnInfo) other;
            this.formatIndex = otherInfo.formatIndex;
            this.widthIndex = otherInfo.widthIndex;
            this.heightIndex = otherInfo.heightIndex;
            this.filenameIndex = otherInfo.filenameIndex;
            this.idIndex = otherInfo.idIndex;
            this.authorIndex = otherInfo.authorIndex;
            this.author_urlIndex = otherInfo.author_urlIndex;
            this.post_urlIndex = otherInfo.post_urlIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final FeedResponseColumnInfo clone() {
            return (FeedResponseColumnInfo) super.clone();
        }

    }
    private FeedResponseColumnInfo columnInfo;
    private ProxyState<me.anil.imageloader.repository.FeedResponse> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("format");
        fieldNames.add("width");
        fieldNames.add("height");
        fieldNames.add("filename");
        fieldNames.add("id");
        fieldNames.add("author");
        fieldNames.add("author_url");
        fieldNames.add("post_url");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    FeedResponseRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FeedResponseColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<me.anil.imageloader.repository.FeedResponse>(me.anil.imageloader.repository.FeedResponse.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$format() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.formatIndex);
    }

    public void realmSet$format(String value) {
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
                row.getTable().setNull(columnInfo.formatIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.formatIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.formatIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.formatIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$width() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.widthIndex);
    }

    public void realmSet$width(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.widthIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.widthIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$height() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.heightIndex);
    }

    public void realmSet$height(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.heightIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.heightIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$filename() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.filenameIndex);
    }

    public void realmSet$filename(String value) {
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
                row.getTable().setNull(columnInfo.filenameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.filenameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.filenameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.filenameIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    public void realmSet$id(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$author() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.authorIndex);
    }

    public void realmSet$author(String value) {
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
                row.getTable().setNull(columnInfo.authorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.authorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.authorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.authorIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$author_url() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.author_urlIndex);
    }

    public void realmSet$author_url(String value) {
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
                row.getTable().setNull(columnInfo.author_urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.author_urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.author_urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.author_urlIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$post_url() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.post_urlIndex);
    }

    public void realmSet$post_url(String value) {
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
                row.getTable().setNull(columnInfo.post_urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.post_urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.post_urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.post_urlIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("FeedResponse")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("FeedResponse");
            realmObjectSchema.add(new Property("format", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("width", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("height", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("filename", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("author", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("author_url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("post_url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("FeedResponse");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_FeedResponse")) {
            Table table = sharedRealm.getTable("class_FeedResponse");
            table.addColumn(RealmFieldType.STRING, "format", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "width", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "height", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "filename", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "author", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "author_url", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "post_url", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_FeedResponse");
    }

    public static FeedResponseColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_FeedResponse")) {
            Table table = sharedRealm.getTable("class_FeedResponse");
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

            final FeedResponseColumnInfo columnInfo = new FeedResponseColumnInfo(sharedRealm.getPath(), table);

            if (table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
            }

            if (!columnTypes.containsKey("format")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'format' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("format") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'format' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.formatIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'format' is required. Either set @Required to field 'format' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("width")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'width' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("width") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'width' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.widthIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'width' does support null values in the existing Realm file. Use corresponding boxed type for field 'width' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("height")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'height' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("height") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'height' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.heightIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'height' does support null values in the existing Realm file. Use corresponding boxed type for field 'height' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("filename")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'filename' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("filename") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'filename' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.filenameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'filename' is required. Either set @Required to field 'filename' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.idIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' does support null values in the existing Realm file. Use corresponding boxed type for field 'id' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("author")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'author' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("author") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'author' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.authorIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'author' is required. Either set @Required to field 'author' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("author_url")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'author_url' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("author_url") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'author_url' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.author_urlIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'author_url' is required. Either set @Required to field 'author_url' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("post_url")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'post_url' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("post_url") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'post_url' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.post_urlIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'post_url' is required. Either set @Required to field 'post_url' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'FeedResponse' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_FeedResponse";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static me.anil.imageloader.repository.FeedResponse createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        me.anil.imageloader.repository.FeedResponse obj = realm.createObjectInternal(me.anil.imageloader.repository.FeedResponse.class, true, excludeFields);
        if (json.has("format")) {
            if (json.isNull("format")) {
                ((FeedResponseRealmProxyInterface) obj).realmSet$format(null);
            } else {
                ((FeedResponseRealmProxyInterface) obj).realmSet$format((String) json.getString("format"));
            }
        }
        if (json.has("width")) {
            if (json.isNull("width")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'width' to null.");
            } else {
                ((FeedResponseRealmProxyInterface) obj).realmSet$width((int) json.getInt("width"));
            }
        }
        if (json.has("height")) {
            if (json.isNull("height")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'height' to null.");
            } else {
                ((FeedResponseRealmProxyInterface) obj).realmSet$height((int) json.getInt("height"));
            }
        }
        if (json.has("filename")) {
            if (json.isNull("filename")) {
                ((FeedResponseRealmProxyInterface) obj).realmSet$filename(null);
            } else {
                ((FeedResponseRealmProxyInterface) obj).realmSet$filename((String) json.getString("filename"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((FeedResponseRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("author")) {
            if (json.isNull("author")) {
                ((FeedResponseRealmProxyInterface) obj).realmSet$author(null);
            } else {
                ((FeedResponseRealmProxyInterface) obj).realmSet$author((String) json.getString("author"));
            }
        }
        if (json.has("author_url")) {
            if (json.isNull("author_url")) {
                ((FeedResponseRealmProxyInterface) obj).realmSet$author_url(null);
            } else {
                ((FeedResponseRealmProxyInterface) obj).realmSet$author_url((String) json.getString("author_url"));
            }
        }
        if (json.has("post_url")) {
            if (json.isNull("post_url")) {
                ((FeedResponseRealmProxyInterface) obj).realmSet$post_url(null);
            } else {
                ((FeedResponseRealmProxyInterface) obj).realmSet$post_url((String) json.getString("post_url"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static me.anil.imageloader.repository.FeedResponse createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        me.anil.imageloader.repository.FeedResponse obj = new me.anil.imageloader.repository.FeedResponse();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("format")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FeedResponseRealmProxyInterface) obj).realmSet$format(null);
                } else {
                    ((FeedResponseRealmProxyInterface) obj).realmSet$format((String) reader.nextString());
                }
            } else if (name.equals("width")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'width' to null.");
                } else {
                    ((FeedResponseRealmProxyInterface) obj).realmSet$width((int) reader.nextInt());
                }
            } else if (name.equals("height")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'height' to null.");
                } else {
                    ((FeedResponseRealmProxyInterface) obj).realmSet$height((int) reader.nextInt());
                }
            } else if (name.equals("filename")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FeedResponseRealmProxyInterface) obj).realmSet$filename(null);
                } else {
                    ((FeedResponseRealmProxyInterface) obj).realmSet$filename((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((FeedResponseRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("author")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FeedResponseRealmProxyInterface) obj).realmSet$author(null);
                } else {
                    ((FeedResponseRealmProxyInterface) obj).realmSet$author((String) reader.nextString());
                }
            } else if (name.equals("author_url")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FeedResponseRealmProxyInterface) obj).realmSet$author_url(null);
                } else {
                    ((FeedResponseRealmProxyInterface) obj).realmSet$author_url((String) reader.nextString());
                }
            } else if (name.equals("post_url")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FeedResponseRealmProxyInterface) obj).realmSet$post_url(null);
                } else {
                    ((FeedResponseRealmProxyInterface) obj).realmSet$post_url((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static me.anil.imageloader.repository.FeedResponse copyOrUpdate(Realm realm, me.anil.imageloader.repository.FeedResponse object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (me.anil.imageloader.repository.FeedResponse) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static me.anil.imageloader.repository.FeedResponse copy(Realm realm, me.anil.imageloader.repository.FeedResponse newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (me.anil.imageloader.repository.FeedResponse) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            me.anil.imageloader.repository.FeedResponse realmObject = realm.createObjectInternal(me.anil.imageloader.repository.FeedResponse.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((FeedResponseRealmProxyInterface) realmObject).realmSet$format(((FeedResponseRealmProxyInterface) newObject).realmGet$format());
            ((FeedResponseRealmProxyInterface) realmObject).realmSet$width(((FeedResponseRealmProxyInterface) newObject).realmGet$width());
            ((FeedResponseRealmProxyInterface) realmObject).realmSet$height(((FeedResponseRealmProxyInterface) newObject).realmGet$height());
            ((FeedResponseRealmProxyInterface) realmObject).realmSet$filename(((FeedResponseRealmProxyInterface) newObject).realmGet$filename());
            ((FeedResponseRealmProxyInterface) realmObject).realmSet$id(((FeedResponseRealmProxyInterface) newObject).realmGet$id());
            ((FeedResponseRealmProxyInterface) realmObject).realmSet$author(((FeedResponseRealmProxyInterface) newObject).realmGet$author());
            ((FeedResponseRealmProxyInterface) realmObject).realmSet$author_url(((FeedResponseRealmProxyInterface) newObject).realmGet$author_url());
            ((FeedResponseRealmProxyInterface) realmObject).realmSet$post_url(((FeedResponseRealmProxyInterface) newObject).realmGet$post_url());
            return realmObject;
        }
    }

    public static long insert(Realm realm, me.anil.imageloader.repository.FeedResponse object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(me.anil.imageloader.repository.FeedResponse.class);
        long tableNativePtr = table.getNativeTablePointer();
        FeedResponseColumnInfo columnInfo = (FeedResponseColumnInfo) realm.schema.getColumnInfo(me.anil.imageloader.repository.FeedResponse.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$format = ((FeedResponseRealmProxyInterface)object).realmGet$format();
        if (realmGet$format != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.formatIndex, rowIndex, realmGet$format, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.widthIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$width(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.heightIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$height(), false);
        String realmGet$filename = ((FeedResponseRealmProxyInterface)object).realmGet$filename();
        if (realmGet$filename != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.filenameIndex, rowIndex, realmGet$filename, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$id(), false);
        String realmGet$author = ((FeedResponseRealmProxyInterface)object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        }
        String realmGet$author_url = ((FeedResponseRealmProxyInterface)object).realmGet$author_url();
        if (realmGet$author_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.author_urlIndex, rowIndex, realmGet$author_url, false);
        }
        String realmGet$post_url = ((FeedResponseRealmProxyInterface)object).realmGet$post_url();
        if (realmGet$post_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.post_urlIndex, rowIndex, realmGet$post_url, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(me.anil.imageloader.repository.FeedResponse.class);
        long tableNativePtr = table.getNativeTablePointer();
        FeedResponseColumnInfo columnInfo = (FeedResponseColumnInfo) realm.schema.getColumnInfo(me.anil.imageloader.repository.FeedResponse.class);
        me.anil.imageloader.repository.FeedResponse object = null;
        while (objects.hasNext()) {
            object = (me.anil.imageloader.repository.FeedResponse) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$format = ((FeedResponseRealmProxyInterface)object).realmGet$format();
                if (realmGet$format != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.formatIndex, rowIndex, realmGet$format, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.widthIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$width(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.heightIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$height(), false);
                String realmGet$filename = ((FeedResponseRealmProxyInterface)object).realmGet$filename();
                if (realmGet$filename != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.filenameIndex, rowIndex, realmGet$filename, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$id(), false);
                String realmGet$author = ((FeedResponseRealmProxyInterface)object).realmGet$author();
                if (realmGet$author != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
                }
                String realmGet$author_url = ((FeedResponseRealmProxyInterface)object).realmGet$author_url();
                if (realmGet$author_url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.author_urlIndex, rowIndex, realmGet$author_url, false);
                }
                String realmGet$post_url = ((FeedResponseRealmProxyInterface)object).realmGet$post_url();
                if (realmGet$post_url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.post_urlIndex, rowIndex, realmGet$post_url, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, me.anil.imageloader.repository.FeedResponse object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(me.anil.imageloader.repository.FeedResponse.class);
        long tableNativePtr = table.getNativeTablePointer();
        FeedResponseColumnInfo columnInfo = (FeedResponseColumnInfo) realm.schema.getColumnInfo(me.anil.imageloader.repository.FeedResponse.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$format = ((FeedResponseRealmProxyInterface)object).realmGet$format();
        if (realmGet$format != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.formatIndex, rowIndex, realmGet$format, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.formatIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.widthIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$width(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.heightIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$height(), false);
        String realmGet$filename = ((FeedResponseRealmProxyInterface)object).realmGet$filename();
        if (realmGet$filename != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.filenameIndex, rowIndex, realmGet$filename, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.filenameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$id(), false);
        String realmGet$author = ((FeedResponseRealmProxyInterface)object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
        }
        String realmGet$author_url = ((FeedResponseRealmProxyInterface)object).realmGet$author_url();
        if (realmGet$author_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.author_urlIndex, rowIndex, realmGet$author_url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.author_urlIndex, rowIndex, false);
        }
        String realmGet$post_url = ((FeedResponseRealmProxyInterface)object).realmGet$post_url();
        if (realmGet$post_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.post_urlIndex, rowIndex, realmGet$post_url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.post_urlIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(me.anil.imageloader.repository.FeedResponse.class);
        long tableNativePtr = table.getNativeTablePointer();
        FeedResponseColumnInfo columnInfo = (FeedResponseColumnInfo) realm.schema.getColumnInfo(me.anil.imageloader.repository.FeedResponse.class);
        me.anil.imageloader.repository.FeedResponse object = null;
        while (objects.hasNext()) {
            object = (me.anil.imageloader.repository.FeedResponse) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$format = ((FeedResponseRealmProxyInterface)object).realmGet$format();
                if (realmGet$format != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.formatIndex, rowIndex, realmGet$format, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.formatIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.widthIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$width(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.heightIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$height(), false);
                String realmGet$filename = ((FeedResponseRealmProxyInterface)object).realmGet$filename();
                if (realmGet$filename != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.filenameIndex, rowIndex, realmGet$filename, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.filenameIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((FeedResponseRealmProxyInterface)object).realmGet$id(), false);
                String realmGet$author = ((FeedResponseRealmProxyInterface)object).realmGet$author();
                if (realmGet$author != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
                }
                String realmGet$author_url = ((FeedResponseRealmProxyInterface)object).realmGet$author_url();
                if (realmGet$author_url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.author_urlIndex, rowIndex, realmGet$author_url, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.author_urlIndex, rowIndex, false);
                }
                String realmGet$post_url = ((FeedResponseRealmProxyInterface)object).realmGet$post_url();
                if (realmGet$post_url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.post_urlIndex, rowIndex, realmGet$post_url, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.post_urlIndex, rowIndex, false);
                }
            }
        }
    }

    public static me.anil.imageloader.repository.FeedResponse createDetachedCopy(me.anil.imageloader.repository.FeedResponse realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        me.anil.imageloader.repository.FeedResponse unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (me.anil.imageloader.repository.FeedResponse)cachedObject.object;
            } else {
                unmanagedObject = (me.anil.imageloader.repository.FeedResponse)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new me.anil.imageloader.repository.FeedResponse();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((FeedResponseRealmProxyInterface) unmanagedObject).realmSet$format(((FeedResponseRealmProxyInterface) realmObject).realmGet$format());
        ((FeedResponseRealmProxyInterface) unmanagedObject).realmSet$width(((FeedResponseRealmProxyInterface) realmObject).realmGet$width());
        ((FeedResponseRealmProxyInterface) unmanagedObject).realmSet$height(((FeedResponseRealmProxyInterface) realmObject).realmGet$height());
        ((FeedResponseRealmProxyInterface) unmanagedObject).realmSet$filename(((FeedResponseRealmProxyInterface) realmObject).realmGet$filename());
        ((FeedResponseRealmProxyInterface) unmanagedObject).realmSet$id(((FeedResponseRealmProxyInterface) realmObject).realmGet$id());
        ((FeedResponseRealmProxyInterface) unmanagedObject).realmSet$author(((FeedResponseRealmProxyInterface) realmObject).realmGet$author());
        ((FeedResponseRealmProxyInterface) unmanagedObject).realmSet$author_url(((FeedResponseRealmProxyInterface) realmObject).realmGet$author_url());
        ((FeedResponseRealmProxyInterface) unmanagedObject).realmSet$post_url(((FeedResponseRealmProxyInterface) realmObject).realmGet$post_url());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("FeedResponse = [");
        stringBuilder.append("{format:");
        stringBuilder.append(realmGet$format() != null ? realmGet$format() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{width:");
        stringBuilder.append(realmGet$width());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{height:");
        stringBuilder.append(realmGet$height());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{filename:");
        stringBuilder.append(realmGet$filename() != null ? realmGet$filename() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{author:");
        stringBuilder.append(realmGet$author() != null ? realmGet$author() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{author_url:");
        stringBuilder.append(realmGet$author_url() != null ? realmGet$author_url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{post_url:");
        stringBuilder.append(realmGet$post_url() != null ? realmGet$post_url() : "null");
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
        FeedResponseRealmProxy aFeedResponse = (FeedResponseRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFeedResponse.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFeedResponse.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFeedResponse.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
