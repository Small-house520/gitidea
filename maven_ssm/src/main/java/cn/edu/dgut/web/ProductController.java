package cn.edu.dgut.web;

import cn.edu.dgut.pojo.Product;
import cn.edu.dgut.service.ProductService;
import cn.edu.dgut.util.MyException;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 小房子
 * @Package cn.edu.dgut.web
 * @date 2020/8/10 15:23
 */
// @RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // 获取全部商品信息
    // 配置url的访问映射
    @RequestMapping("/product")
    public ModelAndView getProductList() throws MyException {
        ModelAndView view = new ModelAndView("productList");

        /*// 手动添加bug测试
        int i = 1 / 0;

        if (true) {
            throw new MyException("出错了，找不到商品信息！！！");
        }*/

        /*// 获得全部商品的信息
        List<Product> productList = productService.getProductList();
        // 让view携带数据过去
        view.addObject("productList", productList);*/

        return view;
    }

    // 分页显示商品信息
    @RequestMapping("/productPage")
    // 将返回结果转成json对象
    @ResponseBody
    // 直接通过属性名获取提交的参数
    public Map<String, Object> getproductListPage(@RequestParam(defaultValue = "1") String page,
                                                  @RequestParam(defaultValue = "10") String limit) throws IOException {
        // 获取分页查询的结果
        PageInfo<Product> pageInfo = productService.getProductPage(Integer.parseInt(page),
                Integer.parseInt(limit));
        // 定义一个Map集合
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        // 将map对象转换为json
        // ObjectMapper mapper = new ObjectMapper();
        // String json = mapper.writeValueAsString(map);

        return map;
    }

    // 跳转到添加商品页面
    @RequestMapping("/itemAdd.action")
    public String addProduct() {
        // 默认是请求转发jsp页面
        return "productadd";
        // forward：请求转发 请求
        // return "forward:/additem.action";
        // forward：重定向 请求
        // return "redirect:/additem.action";
    }

    // 添加商品
    @RequestMapping("/additem.action")
    public String addProduct(Product product, MultipartFile pictureFile, Model model) throws IOException {
        // 判断是否上传了文件
        if (pictureFile != null && !pictureFile.isEmpty()) {
            // 得到原文件名
            String originalFilename = pictureFile.getOriginalFilename();
            // 截取文件后缀并修改文件名，UUID.randomUUID()唯一的随机码
            String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf(
                    "."));

            // 把文件名存到数据库
            product.setPic(filename);
            // 下载文件到指定路径
            pictureFile.transferTo(new File("D:\\project\\idea\\javaee\\ssm01\\web\\images\\" + filename));
        }

        String message = "";
        if (productService.addProduct(product)) {
            message = "添加成功！";
        } else {
            message = "添加失败！";
        }
        // 把添加结果传递过去
        model.addAttribute("message", message);

        return "success";
    }

    // 删除商品
    @RequestMapping("/deleteitem.action")
    public String deleteProduct(String[] ids, Model model) {
        System.out.println(ids);
        String message = "";
        if (productService.deleteProduct(ids)) {
            message = "删除成功！";
        } else {
            message = "删除失败！";
        }
        model.addAttribute("message", message);
        return "success";
    }

    // 根据id查询商品信息
    @RequestMapping("/itemEdit.action/{id}")
    public ModelAndView getProductById(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("productItem");
        Product product = null;
        if (id != null && !("".equals(id))) {
            product = productService.getProductById(Integer.parseInt(id));
        }
        view.addObject("item", product);
        return view;
    }

    // 修改商品信息
    @RequestMapping("/updateitem.action")
    // 通过对象获得上传的参数
    public ModelAndView updateProduct(Product product, MultipartFile pictureFile) throws IOException {
        ModelAndView view = new ModelAndView("success");

        if (pictureFile != null && !pictureFile.isEmpty()) {
            // 得到原文件名
            String originalFilename = pictureFile.getOriginalFilename();
            System.out.println(originalFilename);

            // 截取文件后缀并修改文件名，UUID.randomUUID()唯一的随机码
            String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf(
                    "."));
            System.out.println(originalFilename);

            // 把文件名存到数据库
            product.setPic(filename);
            // 下载文件到指定路径
            pictureFile.transferTo(new File("D:\\project\\idea\\javaee\\ssm01\\web\\images\\" + filename));

            // File file = new File();
            // if (!file.exists()){
            //    file.mkdirs()
            // }
        }

        String message = "";
        if (productService.updateProduct(product)) {
            message = "修改成功！";
        } else {
            message = "修改失败！";
        }

        view.addObject("message", message);
        return view;
    }

    // 查询商品信息
    @RequestMapping("/queryitem.action")
    // 直接通过属性名获取提交的参数
    public String findProductByName(@RequestParam(defaultValue = "1") String page,
                                    @RequestParam(defaultValue = "10") String limit,
                                    Product product, Model model) throws IOException {

        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        model.addAttribute("product", product);
        return "forward:/productPage";
    }
}
