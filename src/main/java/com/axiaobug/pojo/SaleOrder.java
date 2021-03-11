package com.axiaobug.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale_orders")
public class SaleOrder {

    public SaleOrder(Date due_date, String purchaser_name, String mobile,
                     String area_code, String product_name, String order_num,
                     BigDecimal sale_price, Date install_date, String powder_color) {
        this.due_date = due_date;
        this.purchaser_name = purchaser_name;
        this.mobile = mobile;
        this.area_code = area_code;
        this.product_name = product_name;
        this.order_num = order_num;
        this.sale_price = sale_price;
        this.install_date = install_date;
        this.powder_color = powder_color;
    }

    public SaleOrder(Integer order_id, Date due_date, String purchaser_name, String mobile, String area_code, String product_name, String order_num, BigDecimal sale_price, Date install_date, String powder_color) {
        this.order_id = order_id;
        this.due_date = due_date;
        this.purchaser_name = purchaser_name;
        this.mobile = mobile;
        this.area_code = area_code;
        this.product_name = product_name;
        this.order_num = order_num;
        this.sale_price = sale_price;
        this.install_date = install_date;
        this.powder_color = powder_color;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date due_date;

    @Column
    private String purchaser_name;

    @Column
    private String mobile;

    @Column
    private String area_code;

    @Column
    private String product_name;

    @Column
    private String order_num;

    @Column(scale = 2)
    private BigDecimal sale_price;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date install_date;

    @Column
    private String powder_color;

// design department start
    @Column
    @Temporal(TemporalType.DATE)
    private Date layout_date;
// design department end

    // process start
    @Column
    private String pool_location;

    @Column
    @Temporal(TemporalType.DATE)
    private Date pick_date;

    @Column
    private Integer pick_id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date tig_date;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fit_date;


    @Column
    @Temporal(TemporalType.DATE)
    private Date qc_date;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fold_date;

    @ManyToOne(targetEntity = Employees.class)
    @JoinColumn(name = "pick_id",referencedColumnName = "employees_id",insertable = false,updatable = false)
    private Employees employees;

}
