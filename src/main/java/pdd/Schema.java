package pdd;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by pojun on 2019/1/23.
 */
public class Schema {
    private String field;
    private String type;
    private String isNull;
    private String isKey;
    private String extra;
    private String comment;

    public Schema(String field, String type, String isNull, String isKey, String extra, String comment) {
        this.field = field;
        this.type = type;
        this.isNull = isNull;
        this.isKey = isKey;
        this.extra = extra;
        this.comment = comment;
    }

    public String format() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(field).append(StringUtils.repeat(" ", 30 - field.length()))
                .append(type).append(StringUtils.repeat(" ", 20 - type.length()))
                .append(isNull).append(StringUtils.repeat(" ", 10 - isNull.length()))
                .append(isKey).append(StringUtils.repeat(" ", 10 - isKey.length()))
                .append(extra).append(StringUtils.repeat(" ", 30 - extra.length()))
                .append(comment);
        return stringBuilder.toString();
    }

    public static String attributeFormat() {
        return new Schema("field", "type", "null",
                "key", "extra","comment").format();
    }
}
