package io.dwak.sqlite_cte_test;

import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;
import io.dwak.sqlite_cte_test.model.FamilyModel;

@AutoValue
public abstract class Family implements FamilyModel {
    public static final Factory<Family> FACTORY = new Factory<>(Family::create);
    public static final Mapper<Family> MAPPER = new Mapper<>(FACTORY);
    public static final String SELECT_ANCESTORS = "WITH RECURSIVE\n" +
        "parent_of(name, parent) AS\n" +
        "(SELECT name, mom FROM family UNION SELECT name, dad FROM family),\n" +
        "ancestor_of_jaden(name) AS\n" +
        "(SELECT parent FROM parent_of WHERE name='Jaden' UNION ALL SELECT parent FROM parent_of JOIN " +
        "ancestor_of_jaden USING(name)) SELECT family.name FROM ancestor_of_jaden, family WHERE ancestor_of_jaden.name=family.name\n";

    @Nullable
    @Override
    public abstract String name();

    @Nullable
    @Override
    public abstract String mom();

    @Nullable
    @Override
    public abstract String dad();

    @Nullable
    @Override
    public abstract Long born();

    @Nullable
    @Override
    public abstract Long died();

    public static Family create(String name,
                         String mom,
                         String dad,
                         Long born,
                         Long died) {
        return builder()
            .name(name)
            .mom(mom)
            .dad(dad)
            .born(born)
            .died(died)
            .build();
    }

    public static Builder builder() {
        return new AutoValue_Family.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        abstract Builder name(String name);

        abstract Builder mom(String mom);

        abstract Builder dad(String dad);

        abstract Builder born(Long born);

        abstract Builder died(Long died);

        abstract Family build();
    }
}
