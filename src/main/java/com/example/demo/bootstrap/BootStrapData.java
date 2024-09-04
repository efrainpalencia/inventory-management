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
        System.out.println("Hi");
    }
//        if (0 == partRepository.count() && 0 == productRepository.count()) {
//            this.addSamplePartsProducts();
//        }
//
//        System.out.println("Started in Bootstrap");
//        System.out.println("Number of Products: " + this.productRepository.count());
//        System.out.println(this.productRepository.findAll());
//        System.out.println("Number of Parts: " + this.partRepository.count());
//        System.out.println(this.partRepository.findAll());
//    }
//
//    private void addSamplePartsProducts() {
//
//        final InhousePart part1 = new InhousePart();
//        part1.setName("REAL WOODEN RISERS SET 5PLY 1/4″ THUNDER");
//        part1.setPrice(5.0);
//        part1.setInv(5);
//        part1.setMinInventory(1);
//        part1.setMaxInventory(10);
//
//        this.inhousePartRepository.save(part1);
//
//        final InhousePart part2 = new InhousePart();
//        part2.setName("THERE MILLER AROUND DECK-8.5X32.0");
//        part2.setPrice(75.0);
//        part2.setInv(5);
//        part2.setMinInventory(1);
//        part2.setMaxInventory(10);
//
//        this.inhousePartRepository.save(part2);
//
//        final OutsourcedPart part3 = new OutsourcedPart();
//        part3.setName("VENTURE SYLLA VCH HI 5.8 BLOODSHOT POLISHED x2");
//        part3.setPrice(65.0);
//        part3.setInv(5);
//        part3.setMinInventory(1);
//        part3.setMaxInventory(10);
//        part3.setCompanyName("Skateboard.com");
//
//        this.outsourcedPartRepository.save(part3);
//
//
//        final OutsourcedPart part4 = new OutsourcedPart();
//        part4.setName("QUANTUM DIAMOND SERIES CERAMIC HYBRID BEARINGS X4");
//        part4.setPrice(15.0);
//        part4.setInv(5);
//        part4.setMinInventory(1);
//        part4.setMaxInventory(10);
//        part4.setCompanyName("Skateboard.com");
//
//        this.outsourcedPartRepository.save(part4);
//
//        final OutsourcedPart part5 = new OutsourcedPart();
//        part5.setName("PWL/P DF NANO CUBIC 60/38MM 97A WHITE X4");
//        part5.setPrice(50.0);
//        part5.setInv(5);
//        part5.setMinInventory(1);
//        part5.setMaxInventory(10);
//        part5.setCompanyName("Skateboard.com");
//
//        this.outsourcedPartRepository.save(part5);
//
//
//        final Product product1 = new Product("Phantom X Pro Skateboard","Elevate your ride with the Phantom X Pro Skateboard. Designed for both beginners and seasoned skaters, this board features a 7-ply maple deck with medium concave for optimal control and balance. Equipped with 53mm 99A wheels and ABEC-7 bearings, the Phantom X Pro offers a smooth and responsive ride on streets, parks, or ramps. The striking black and neon green graphics make a bold statement, ensuring you look as good as you skate.","skateboard1.png", 500.0, 1);
//        final Set<Part> parts1 = product1.getParts();
//        parts1.add(part1);
//        parts1.add(part2);
//        parts1.add(part3);
//        parts1.add(part4);
//        parts1.add(part5);
//
//        product1.setParts(parts1);
//        String image = product1.getImage();
//        this.productRepository.save(product1);
//
//        final Product product2 = new Product("CruiseMaster 32\" Longboard","Glide through the streets in style with the CruiseMaster 32\" Longboard. Perfect for commuting or casual cruising, this board boasts a durable bamboo and maple hybrid deck that’s both flexible and sturdy. The wide, 70mm soft wheels provide exceptional grip and a buttery-smooth ride, even on rough pavement. With a sleek retro design and a comfortable foot platform, the CruiseMaster is your go-to board for effortless carving and long-distance rides.","skateboard2.png", 500.0, 1);
//        final Set<Part> parts2 = product2.getParts();
//        parts2.add(part1);
//        parts2.add(part2);
//        parts2.add(part3);
//        parts2.add(part4);
//        parts2.add(part5);
//
//        product2.setParts(parts2);
//        this.productRepository.save(product2);
//
//        final Product product3 = new Product("Thunderbolt Electric Skateboard", "Experience the future of skateboarding with the Thunderbolt Electric Skateboard. Powered by a 400W brushless motor, this board reaches speeds of up to 22 mph, perfect for thrill-seekers and commuters alike. The durable 8-layer maple deck is reinforced with fiberglass for added strength, while the regenerative braking system ensures you can stop on a dime. With a wireless remote control and a range of up to 15 miles on a single charge, the Thunderbolt is your ultimate companion for fast-paced urban adventures.","skateboard3.png",500.0, 1);
//        final Set<Part> parts3 = product3.getParts();
//        parts3.add(part1);
//        parts3.add(part2);
//        parts3.add(part3);
//        parts3.add(part4);
//        parts3.add(part5);
//
//        product3.setParts(parts3);
//        this.productRepository.save(product3);
//
//        final Product product4 = new Product("Trickster Mini Skateboard", "Compact, portable, and ready to shred, the Trickster Mini Skateboard is the perfect choice for skaters on the go. Despite its small size, this 22\" board packs a punch with its high-density plastic deck, offering maximum durability and a responsive ride. The 59mm soft wheels and high-precision bearings make it ideal for cruising through tight spaces or mastering tricks at the skate park. Available in a variety of vibrant colors, the Trickster Mini is a fun and versatile board that fits easily in your backpack.", "skateboard4.png",500.0, 1);
//        final Set<Part> parts4 = product4.getParts();
//        parts4.add(part1);
//        parts4.add(part2);
//        parts4.add(part3);
//        parts4.add(part4);
//        parts4.add(part5);
//
//        product4.setParts(parts4);
//        this.productRepository.save(product4);
//
//        final Product product5 = new Product("Titan Freestyle Skateboard", "Push your limits with the Titan Freestyle Skateboard, engineered for advanced tricks and high-performance skating. The 8.0\" wide deck is crafted from Canadian maple, providing a sturdy yet lightweight platform for flips, ollies, and grinds. Outfitted with 52mm 100A wheels and premium-grade trucks, the Titan delivers precision control and excellent pop. The bold graphic design is scratch-resistant, keeping your board looking fresh even after the toughest sessions. Whether you're hitting the streets or the half-pipe, the Titan Freestyle is built to perform.","skateboard5.png",500.0, 1);
//        final Set<Part> parts5 = product5.getParts();
//        parts5.add(part1);
//        parts5.add(part2);
//        parts5.add(part3);
//        parts5.add(part4);
//        parts5.add(part5);
//
//        product5.setParts(parts5);
//        this.productRepository.save(product5);
//    }
}
