package com.cc.model;

import java.util.Date;

public class RoleDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_id
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    private Date updateAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    private Date createAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.delete_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    private Date deleteAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_id
     *
     * @return the value of role.role_id
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_id
     *
     * @param roleId the value for role.role_id
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_at
     *
     * @return the value of role.update_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_at
     *
     * @param updateAt the value for role.update_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_at
     *
     * @return the value of role.create_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_at
     *
     * @param createAt the value for role.create_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.delete_at
     *
     * @return the value of role.delete_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public Date getDeleteAt() {
        return deleteAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.delete_at
     *
     * @param deleteAt the value for role.delete_at
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }
}