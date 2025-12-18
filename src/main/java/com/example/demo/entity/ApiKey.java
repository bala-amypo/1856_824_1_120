// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;
// import org.hibernate.annotations.CreationTimestamp;
// import org.hibernate.annotations.UpdateTimestamp;


// import java.sql.Timestamp;


// @Entity
// public class ApiKey{

//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique=true)
//     private String keyValue;
//     private Long ownerId;
//     private String plan;
//     private Boolean active = true;
//     @CreationTimestamp
//     private Timestamp createdAt;
//     @UpdateTimestamp
//     private Timestamp updatedAt;

//     //@PrePersist
//     //public void onCreate(){
//         //this.createdAt=new Timestamp(System.currentTimeMillis());
//    // }

//    // @PrePersist
//    //public void onCreates(){
//        //this.updatedAt=new Timestamp(System.currentTimeMillis());
//     //}

//    public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getKeyValue() {
//         return keyValue;
//     }

//     public void setKeyValue(String keyValue) {
//         this.keyValue = keyValue;
//     }

//     public Long getOwnerId() {
//         return ownerId;
//     }

//     public void setOwnerId(Long ownerId) {
//         this.ownerId = ownerId;
//     }

//     public String getPlan() {
//         return plan;
//     }

//     public void setPlan(String plan) {
//         this.plan = plan;
//     }

//     public Boolean getActive() {
//         return active;
//     }

//     public void setActive(Boolean active) {
//         this.active = active;
//     }

//     public Timestamp getCreatedAt() {
//         return createdAt;
//     }

//     // public void setCreatedAt(Timestamp createdAt) {
//     //     this.createdAt = createdAt;
//     // }

//     public Timestamp getUpdatedAt() {
//         return updatedAt;
//     }

//     // public void setUpdatedAt(Timestamp updatedAt) {
//     //     this.updatedAt = updatedAt;
//     // }

//     public ApiKey(Long id, String keyValue, Long ownerld, QuotaPlan plan, Boolean active, Timestamp createdAt, Timestamp updatedAt){
//         this.id=id;
//         this.keyValue=keyValue;
//         this.ownerId=ownerId;
//         this.plan=plan;
//         this.active=active;
//         this.createdAt=createdAt;
//         this.updatedAt=updatedAt;
//     }
//     public ApiKey(){
        
//     }
// }

