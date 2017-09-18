package com.andigeeky.customizedfontexamples.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Builder class for constructing a query for downloading a font.
 */
public class QueryBuilder {

    public static final int WIDTH_DEFAULT = 100;
    public static final int WIDTH_MAX = 1000;
    public static final int WIDTH_MIN = 0;

    public static final int WEIGHT_DEFAULT = 400;
    public static final int WEIGHT_MAX = 1000;
    public static final int WEIGHT_MIN = 0;

    public static final float ITALIC_DEFAULT = 0f;
    public static final float ITALIC_MAX = 1f;
    public static final float ITALIC_MIN = 0f;

    @NonNull
    private String familyName;

    @Nullable
    private Float width = null;

    @Nullable
    private Integer weight = null;

    @Nullable
    private Float italic = null;

    @Nullable
    private Boolean besteffort = null;

    public QueryBuilder(@NonNull String familyName) {
        this.familyName = familyName;
    }

    public QueryBuilder withFamilyName(@NonNull String familyName) {
        this.familyName = familyName;
        return this;
    }

    public  QueryBuilder withWidth(float width) {
        if (width <= WIDTH_MIN) {
            throw new IllegalArgumentException("Width must be more than 0");
        }
        this.width = width;
        return this;
    }

    public QueryBuilder withWeight(int weight) {
        if (weight <= WEIGHT_MIN || weight >= WEIGHT_MAX) {
            throw new IllegalArgumentException(
                    "Weight must be between 0 and 1000 (exclusive)");
        }
        this.weight = weight;
        return this;
    }

    public QueryBuilder withItalic(float italic) {
        if (italic < ITALIC_MIN || italic > ITALIC_MAX) {
            throw new IllegalArgumentException("Italic must be between 0 and 1 (inclusive)");
        }
        this.italic = italic;
        return this;
    }

    public QueryBuilder withBestEffort(boolean bestEffort) {
        besteffort = bestEffort;
        return this;
    }

    public String build() {
        if (weight == null && width == null && italic == null && besteffort == null) {
            return familyName;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("name=").append(familyName);
        if (weight != null) {
            builder.append("&weight=").append(weight);
        }
        if (width != null) {
            builder.append("&width=").append(width);
        }
        if (italic != null) {
            builder.append("&italic=").append(italic);
        }
        if (besteffort != null) {
            builder.append("&besteffort=").append(besteffort);
        }
        return builder.toString();
    }
}
