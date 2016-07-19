package io.dwak.sqlite_cte_test;

import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;
import io.dwak.sqlite_cte_test.model.FamilyModel;

@AutoValue
public abstract class Family implements FamilyModel {
    public static final Factory<Family> FACTORY = new Factory<>(Family::create);
    public static final Mapper<Family> MAPPER = new Mapper<>(FACTORY);

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
