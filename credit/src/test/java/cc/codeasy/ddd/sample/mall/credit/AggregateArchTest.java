package cc.codeasy.ddd.sample.mall.credit;

import cc.codeasy.ddd.sample.mall.credit.common.Aggregate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SliceAssignment;
import com.tngtech.archunit.library.dependencies.SliceIdentifier;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "cc.codeasy.ddd.sample.mall.credit.domain.model")
public class AggregateArchTest {

    @ArchTest
    static final ArchRule aggregates_should_not_depend_each_other =
            slices().assignedFrom(new SliceAssignment(){
                @Override
                public String getDescription() {
                    return "aggregate slices";
                }
                @Override
                public SliceIdentifier getIdentifierOf(JavaClass javaClass) {
                    return javaClass.isAnnotatedWith(Aggregate.class) ?
                            SliceIdentifier.of("aggregate["+javaClass.getSimpleName()+"]")
                            : SliceIdentifier.ignore();
                }
            }).as("aggregates").should().notDependOnEachOther();


}
