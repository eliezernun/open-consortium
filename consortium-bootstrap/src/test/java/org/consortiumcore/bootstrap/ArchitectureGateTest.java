package org.consortiumcore.bootstrap;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.consortiumcore.productcatalog.application.port.out.ConfigurationHashGenerator;
import org.consortiumcore.productcatalog.application.port.out.DomainEventPublisher;
import org.consortiumcore.productcatalog.application.port.out.ProductRepository;
import org.consortiumcore.productcatalog.application.port.out.ProductTypeProvider;
import org.consortiumcore.productcatalog.application.port.out.ProductVersionRepository;
import org.consortiumcore.productcatalog.application.port.out.RegulationProfileProvider;
import org.consortiumcore.productcatalog.domain.product.Product;
import org.consortiumcore.productcatalog.domain.version.ProductVersion;
import org.consortiumcore.productcatalog.infrastructure.event.NoOpDomainEventPublisher;
import org.consortiumcore.productcatalog.infrastructure.hash.StableConfigurationHashGenerator;
import org.consortiumcore.productcatalog.infrastructure.persistence.adapter.InMemoryProductRepository;
import org.consortiumcore.productcatalog.infrastructure.persistence.adapter.InMemoryProductVersionRepository;
import org.consortiumcore.productcatalog.infrastructure.regulation.FixedRegulationProfileProvider;
import org.consortiumcore.productcatalog.infrastructure.type.RegistryProductTypeProvider;
import org.consortiumcore.group.domain.ConsortiumGroup;
import org.junit.jupiter.api.Test;

class ArchitectureGateTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("org.consortiumcore");

    @Test
    void domainDoesNotDependOnSpringOrPersistence() {
        noClasses()
                .that()
                .resideInAPackage("..domain..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("org.springframework..", "jakarta.persistence..", "javax.persistence..")
                .check(classes);
    }

    @Test
    void applicationDoesNotDependOnSpringPersistenceOrInfrastructure() {
        noClasses()
                .that()
                .resideInAPackage("..application..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("org.springframework..", "jakarta.persistence..", "javax.persistence..", "..infrastructure..")
                .check(classes);
    }

    @Test
    void domainEventsDoNotDependOnSpring() {
        noClasses()
                .that()
                .resideInAPackage("..domain.event..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("org.springframework..")
                .check(classes);
    }

    @Test
    void publicApiDoesNotExposeDomainTypes() {
        noClasses()
                .that()
                .resideInAPackage("..api..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("..domain..")
                .check(classes);
    }

    @Test
    void aggregatesDoNotExposeStateSetters() {
        assertNoSetters(Product.class);
        assertNoSetters(ProductVersion.class);
        assertNoSetters(ConsortiumGroup.class);
    }

    @Test
    void productCatalogInfrastructureImplementsApplicationPorts() {
        assertTrue(ProductRepository.class.isAssignableFrom(InMemoryProductRepository.class));
        assertTrue(ProductVersionRepository.class.isAssignableFrom(InMemoryProductVersionRepository.class));
        assertTrue(DomainEventPublisher.class.isAssignableFrom(NoOpDomainEventPublisher.class));
        assertTrue(ConfigurationHashGenerator.class.isAssignableFrom(StableConfigurationHashGenerator.class));
        assertTrue(ProductTypeProvider.class.isAssignableFrom(RegistryProductTypeProvider.class));
        assertTrue(RegulationProfileProvider.class.isAssignableFrom(FixedRegulationProfileProvider.class));
    }

    private static void assertNoSetters(Class<?> aggregateType) {
        for (var method : aggregateType.getDeclaredMethods()) {
            assertTrue(
                    !method.getName().matches("set[A-Z].*"),
                    () -> aggregateType.getName() + " exposes state setter " + method.getName()
            );
        }
    }
}
