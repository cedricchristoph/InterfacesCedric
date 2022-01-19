using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo.dao
{
    /**
     * @param T Object to work with
     * @param E Data type of identifier in database
     */
    public interface ICRUD<T,E>
    {
        T selectById(E id);
        List<T> selectAll();
        bool insert(T entity);
        bool update(T entity);
        bool delete(T entity);
        bool delete(E id);

    }
}
