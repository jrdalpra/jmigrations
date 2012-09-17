import static br.com.wolkenapps.jmigrations.dsl.Commands.*;
import static br.com.wolkenapps.jmigrations.dsl.Models.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Columns.*;
import static br.com.wolkenapps.jmigrations.dsl.Options.Commons.*;
import static br.com.wolkenapps.jmigrations.dsl.Types.*;
import br.com.wolkenapps.jmigrations.engine.api.internal.Dialect;

public class TestsFoDialects {

    private Dialect dialect;

    public void test() {

        String command = dialect.producesARepresentationFor(create(table("user").columns(column("id").type(long_()).notNull(),
                                                                             column("login").type(string()).withOptions(notNull(), length(100)),
                                                                             column("passwd").type(string()).withOptions(notNull(), length(20)))).ifNotExists());

    }

}
