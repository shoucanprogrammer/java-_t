package com.tl.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.VoucherOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IVoucherOrderService extends IService<VoucherOrder> {

    Result seckillVoucher(Long voucherId);

    Result createVoucherOrder(Long voucherId);

    void createVoucherOrder(VoucherOrder voucherOrder);
}
