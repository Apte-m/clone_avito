package com.example.buysell.Service;

import com.example.buysell.models.Image;
import com.example.buysell.models.Product;
import com.example.buysell.repositories.ProductRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> list(String title) {

        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    @SneakyThrows
    public void saveProduct(Product product, MultipartFile one, MultipartFile two, MultipartFile three) {
        Image image1;
        Image image2;
        Image image3;

        if (one.getSize() != 0) {
            image1 = toImageEntity(one);
            image1.setPreviewImage(true);
            product.addImageProduct(image1);
        }
        if (two.getSize() != 0) {
            image2 = toImageEntity(two);
            image2.setPreviewImage(true);
            product.addImageProduct(image2);
        }
        if (three.getSize() != 0) {
            image3 = toImageEntity(one);
            image3.setPreviewImage(true);
            product.addImageProduct(image3);
        }
        log.info("saving product title {} author {}", product.getTitle(),product.getAuthor());
        Product productDb = productRepository.save(product);
        productDb.setPreviewImageId(productDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    @SneakyThrows
    private Image toImageEntity(MultipartFile file) {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void productDelete(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
