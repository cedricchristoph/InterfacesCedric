using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model.dao
{
    public interface CRUD<T,E>
    {
        T selectById(E id);
        List<T> selectAll();
        int insert(T entity);
        int update(T entity);
        int delete(T entity);
    }
}
