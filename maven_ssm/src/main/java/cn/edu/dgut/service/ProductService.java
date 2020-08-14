package cn.edu.dgut.service;

import cn.edu.dgut.pojo.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 小房子
 * @Package cn.edu.dgut.service
 * @date 2020/8/10 15:22
 */
public interface ProductService {

    // 添加商品
    boolean addProduct(Product product);

    // 删除商品
    boolean deleteProduct(String[] ids);

    // 根据id查询商品信息
    Product getProductById(int id);

    // 根据id修改商品信息
    boolean updateProduct(Product product);

    // 根据商品名称查询商品信息
    List<Product> findProductByName(String name);

    // 查询所有商品信息
    List<Product> getProductList();

    // 分页查询商品信息
    PageInfo<Product> getProductPage(int pageNum, int pageSize);

    // 根据商品信息分页查询商品信息
    PageInfo<Product> findProductPage(int pageNum, int pageSize, Product product);

}
