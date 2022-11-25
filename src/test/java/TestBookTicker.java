import io.contek.invoker.binancelinear.api.ApiFactory;
import io.contek.invoker.binancelinear.api.rest.market.GetTickerBookTicker;

public class TestBookTicker {

    public static void main(String[] args) {
        GetTickerBookTicker.Response btcusdt = ApiFactory.getMainNet().rest().market().getTickerBookTicker().setSymbol("btcusdt").submit();
        System.out.println(btcusdt.bidPrice);
    }
}
