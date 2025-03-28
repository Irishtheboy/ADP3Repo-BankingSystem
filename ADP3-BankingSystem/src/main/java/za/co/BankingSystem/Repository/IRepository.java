/*
 * IRepository.java
 * IRepository Class
 * Author: Rorisang Makgana (230602363)
 * Date: 28th March 2025
 */
package za.co.BankingSystem.Repository;

public interface IRepository <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    T delete(ID id);
}
