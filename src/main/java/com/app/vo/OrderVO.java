package com.app.vo;

import java.util.Objects;

public class OrderVO {
   private Long id;
   private Long memberId;
   private Long productId;
   private int productCount;
   
   public OrderVO() {;}

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getMemberId() {
      return memberId;
   }

   public void setMemberId(Long memberId) {
      this.memberId = memberId;
   }

   public Long getProductId() {
      return productId;
   }

   public void setProductId(Long productId) {
      this.productId = productId;
   }

   public int getProductCount() {
      return productCount;
   }

   public void setProductCount(int productCount) {
      this.productCount = productCount;
   }

   @Override
   public String toString() {
      return "OrderVO [id=" + id + ", memberId=" + memberId + ", productId=" + productId + ", productCount="
            + productCount + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      OrderVO other = (OrderVO) obj;
      return Objects.equals(id, other.id);
   }
   
   
}
