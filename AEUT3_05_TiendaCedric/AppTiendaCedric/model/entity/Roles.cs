namespace model.entity
{
    public enum Rol
    {
        BASIC, ADMIN, UNKNOWN
    }
    public class Roles
    {
        public static Rol parseRol(string value)
        {
            switch (value)
            {
                case "basic":
                    return Rol.BASIC;
                case "admin":
                    return Rol.ADMIN;
                default:
                    return Rol.UNKNOWN;
            }
        }

        public static string toString(Rol rol)
        {
            switch (rol)
            {
                case Rol.ADMIN:
                    return "admin";
                case Rol.BASIC:
                    return "basic";
                case Rol.UNKNOWN:
                    return "unknown";
            }
            return "null";
        }
    }
}
