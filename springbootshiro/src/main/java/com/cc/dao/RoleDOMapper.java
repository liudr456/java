package com.cc.dao;

import com.cc.model.RoleDO;

public interface RoleDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    int insert(RoleDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    int insertSelective(RoleDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    RoleDO selectByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    int updateByPrimaryKeySelective(RoleDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Fri Mar 29 09:37:13 CST 2019
     */
    int updateByPrimaryKey(RoleDO record);
}