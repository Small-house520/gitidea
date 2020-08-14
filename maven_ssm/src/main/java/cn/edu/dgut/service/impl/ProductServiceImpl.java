package cn.edu.dgut.service.impl;

import cn.edu.dgut.dao.ProductMapper;
import cn.edu.dgut.pojo.Product;
import cn.edu.dgut.pojo.ProductExample;
import cn.edu.dgut.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小房子
 * @Package cn.edu.dgut.service.impl
 * @date 2020/8/10 15:23
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    // 添加商品
    @Override
    public boolean addProduct(Product product) {
        int i = productMapper.insertSelective(product);
        if (i > 0) {
            return true;
        }
        return false;
    }

    // 删除商品
    @Override
    public boolean deleteProduct(String[] ids) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        List<Integer> list = new ArrayList<>();
        for (String id : ids) {
            list.add(Integer.parseInt(id));
        }
        criteria.andIdIn(list);
        int delete = productMapper.deleteByExample(productExample);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    // 根据id查询商品信息
    @Override
    public Product getProductById(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    // 根据id修改商品信息
    @Override
    public boolean updateProduct(Product product) {
        int update = productMapper.updateByPrimaryKeySelective(product);
        if (update > 0) {
            return true;
        }
        return false;
    }

    // 根据商品名称查询商品信息
    @Override
    public List<Product> findProductByName(String name) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andNameLike("%" + name + "%");
        List<Product> products = productMapper.selectByExampleWithBLOBs(productExample);
        return products;
    }

    // 查询所有商品信息
    @Override
    public List<Product> getProductList() {
        return productMapper.selectByExampleWithBLOBs(null);
    }

    // 分页查询商品信息
    @Override
    public PageInfo<Product> getProductPage(int pageNum, int pageSize) {

        // 设置当前页号和页面大小
        PageHelper.startPage(pageNum, pageSize);
        // 得到分页查询结果
        List<Product> products = productMapper.selectByExampleWithBLOBs(null);

        // 用PageInfo对结果进行包装
        PageInfo pageInfo = new PageInfo(products);

        // 返回查询结果
        return pageInfo;
    }

    // 根据商品信息分页查询商品信息
    @Override
    public PageInfo<Product> findProductPage(int pageNum, int pageSize, Product product) {

        // 设置当前页号和页面大小
        PageHelper.startPage(pageNum, pageSize);
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        if (product.getName() != null && !"".equals(product.getName())) {
            criteria.andNameLike("%" + product.getName() + "%");
        }
        // 得到分页查询结果
        List<Product> products = productMapper.selectByExampleWithBLOBs(productExample);

        // 用PageInfo对结果进行包装
        PageInfo pageInfo = new PageInfo(products);

        // 返回查询结果
        return pageInfo;
    }
}
