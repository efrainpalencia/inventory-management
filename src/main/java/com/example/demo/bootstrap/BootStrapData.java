package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(final PartRepository partRepository, final ProductRepository productRepository,
                         final OutsourcedPartRepository outsourcedPartRepository, final InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        if (0 == partRepository.count() && 0 == productRepository.count()) {
            this.addSamplePartsProducts();
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + this.productRepository.count());
        System.out.println(this.productRepository.findAll());
        System.out.println("Number of Parts: " + this.partRepository.count());
        System.out.println(this.partRepository.findAll());
    }

    private void addSamplePartsProducts() {

        final InhousePart part1 = new InhousePart();
        part1.setName("REAL WOODEN RISERS SET 5PLY 1/4″ THUNDER");
        part1.setPrice(5.0);
        part1.setInv(1);
        part1.setMinInventory(0);
        part1.setMaxInventory(1);

        this.inhousePartRepository.save(part1);

        final InhousePart part2 = new InhousePart();
        part2.setName("THERE MILLER AROUND DECK-8.5X32.0");
        part2.setPrice(75.0);
        part2.setInv(1);
        part2.setMinInventory(0);
        part2.setMaxInventory(1);

        this.inhousePartRepository.save(part2);

        final OutsourcedPart part3 = new OutsourcedPart();
        part3.setName("VENTURE SYLLA VCH HI 5.8 BLOODSHOT POLISHED x2");
        part3.setPrice(65.0);
        part3.setInv(1);
        part3.setMinInventory(0);
        part3.setMaxInventory(1);
        part3.setCompanyName("Skateboard.com");

        this.outsourcedPartRepository.save(part3);


        final OutsourcedPart part4 = new OutsourcedPart();
        part4.setName("QUANTUM DIAMOND SERIES CERAMIC HYBRID BEARINGS X4");
        part4.setPrice(15.0);
        part4.setInv(1);
        part4.setMinInventory(0);
        part4.setMaxInventory(1);
        part4.setCompanyName("Skateboard.com");

        this.outsourcedPartRepository.save(part4);

        final OutsourcedPart part5 = new OutsourcedPart();
        part5.setName("PWL/P DF NANO CUBIC 60/38MM 97A WHITE X4");
        part5.setPrice(50.0);
        part5.setInv(1);
        part5.setMinInventory(0);
        part5.setMaxInventory(1);
        part5.setCompanyName("Skateboard.com");

        this.outsourcedPartRepository.save(part5);


        final Product product1 = new Product("PWL/P CABALLERO CHINESE DRAGON 21 DK-10X30 SAGE", 500.0, 1);
        final Set<Part> parts1 = product1.getParts();
        parts1.add(part1);
        parts1.add(part2);
        parts1.add(part3);
        parts1.add(part4);
        parts1.add(part5);

        product1.setParts(parts1);
        this.productRepository.save(product1);

        final Product product2 = new Product("PWL/P HOEFLER PHOENIX DK-8.0 flight", 500.0, 1);
        final Set<Part> parts2 = product2.getParts();
        parts2.add(part1);
        parts2.add(part2);
        parts2.add(part3);
        parts2.add(part4);
        parts2.add(part5);

        product2.setParts(parts2);
        this.productRepository.save(product2);

        final Product product3 = new Product("PWL/P RODRIGUEZ SKULL/SWORD 10 DK-10X30 RED STAIN", 500.0, 1);
        final Set<Part> parts3 = product3.getParts();
        parts3.add(part1);
        parts3.add(part2);
        parts3.add(part3);
        parts3.add(part4);
        parts3.add(part5);

        product3.setParts(parts3);
        this.productRepository.save(product3);

        final Product product4 = new Product("PRIMITIVE LEMOS ULTIMATE WARRIOR DECK-8.25 BLACK", 500.0, 1);
        final Set<Part> parts4 = product4.getParts();
        parts4.add(part1);
        parts4.add(part2);
        parts4.add(part3);
        parts4.add(part4);
        parts4.add(part5);

        product4.setParts(parts4);
        this.productRepository.save(product4);

        final Product product5 = new Product("BW GREGSON MERCYFUL FATE DECK-8.5", 500.0, 1);
        final Set<Part> parts5 = product5.getParts();
        parts5.add(part1);
        parts5.add(part2);
        parts5.add(part3);
        parts5.add(part4);
        parts5.add(part5);

        product5.setParts(parts5);
        this.productRepository.save(product5);
    }
}
