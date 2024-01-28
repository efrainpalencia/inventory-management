package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {


//        OutsourcedPart o= new OutsourcedPart();
//        o.setCompanyName("Skateboard Wholesale");
//        o.setName("KUNG FU GRIPTAPE SINGLE SHEET 9×33 BLACK");
//        o.setMinInventory(1);
//        o.setMaxInventory(15);
//        o.setInv(5);
//        o.setPrice(6.0);
//        o.setId(4L);
//        outsourcedPartRepository.save(o);
//        OutsourcedPart thePart=null;
//        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedParts){
//            if(part.getName().equals("KUNG FU GRIPTAPE SINGLE SHEET 9×33 BLACK"))thePart=part;
//        }

//        System.out.println(thePart.getCompanyName());

//        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedParts){
//            System.out.println(part.getName()+" "+part.getCompanyName());
//        }

        /*
        Product caballero= new Product("PWL/P CABALLERO CHINESE DRAGON 21 DK-10X30 SAGE",100.0,15);
        Product hoefler= new Product("PWL/P HOEFLER PHOENIX DK-8.0 flight",100.0,15);
        Product rodriguez= new Product("PWL/P RODRIGUEZ SKULL/SWORD 10 DK-10X30 RED STAIN", 100.0, 15);
        Product primitive= new Product("PRIMITIVE LEMOS ULTIMATE WARRIOR DECK-8.25 BLACK", 100.0, 15);
        Product bw= new Product("BW GREGSON MERCYFUL FATE DECK-8.5", 100.0, 15);
        productRepository.save(caballero);
        productRepository.save(hoefler);
        productRepository.save(rodriguez);
        productRepository.save(primitive);
        productRepository.save(bw);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
