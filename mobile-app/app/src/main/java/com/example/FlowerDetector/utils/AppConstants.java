package com.example.FlowerDetector.utils;

import java.util.HashMap;

public class AppConstants {
    public class Common{
        public static final int COMMON_REQUEST_PERMISSION_CODE = 9999;
        public static final String IMG_NAME = "imgName";
        public static final String IMG_PATH = "IMG_PATH";
    }

    public class FlowerUrl {
        public static final String ROSE = "https://vi.wikipedia.org/wiki/Hoa_h%E1%BB%93ng";
    }

    public static final HashMap<String, String> FLOWER_WIKI_URL = new HashMap<String, String>() {
        {
            put("rose", "https://en.wikipedia.org/wiki/Rose");
            put("lotus", "https://en.wikipedia.org/wiki/Nelumbo_nucifera");
            put("daisy", "https://en.wikipedia.org/wiki/Bellis_perennis");
            put("sunflower", "https://en.wikipedia.org/wiki/Helianthus");
            put("common dandelion", "https://en.wikipedia.org/wiki/Taraxacum");
            put("common tulip", "https://en.wikipedia.org/wiki/Tulip");
            put("camellia", "https://en.wikipedia.org/wiki/Camellia");
            put("anthurium", "https://en.wikipedia.org/wiki/Anthurium");
            put("iris", "https://en.wikipedia.org/wiki/Iris_(plant)");
            put("morning glory", "https://en.wikipedia.org/wiki/Morning_glory");
        }
    };

    public static final HashMap<String, String> FLOWER_DESCRIPTION = new HashMap<String, String>() {
        {
            put("rose", "A rose is a woody perennial flowering plant of the genus Rosa, in the family Rosaceae, or the flower it bears. Flowers vary in size and shape and are usually large and showy, in colours ranging from white through yellows and reds.");
            put("lotus", "Nelumbo nucifera, also known as Indian lotus, sacred lotus, bean of India, Egyptian bean or simply lotus, is one of two extant species of aquatic plant in the family Nelumbonaceae. It is often colloquially called a water lily.\nLotus plants are adapted to grow in the flood plains of slow-moving rivers and delta areas.");
            put("daisy", "Bellis perennis is a common European species of daisy, of the family Asteraceae, often considered the archetypal species of that name.\nMany related plants also share the name \"daisy\", so to distinguish this species from other daisies it is sometimes qualified as common daisy, lawn daisy or English daisy.");
            put("sunflower", "Helianthus is a genus of plants comprising about 70 species. The common names \"sunflower\" and \"common sunflower\" typically refer to the popular annual species Helianthus annuus, whose round flower heads in combination with the ligules look like the sun.");
            put("common dandelion", "Taraxacum is a large genus of flowering plants in the family Asteraceae, which consists of species commonly known as dandelions. The genus is native to Eurasia and North America, but the two commonplace species worldwide, T. officinale and T. erythrospermum, were introduced from Europe and now propagate as wildflowers.");
            put("common tulip", "Tulips (Tulipa) form a genus of spring-blooming perennial herbaceous bulbiferous geophytes (having bulbs as storage organs). The flowers are usually large, showy and brightly colored, generally red, pink, yellow, or white (usually in warm colors). They often have a different colored blotch at the base of the tepals (petals and sepals, collectively), internally.");
            put("camellia", "Camellia is a genus of flowering plants in the family Theaceae. They are found in eastern and southern Asia, from the Himalayas east to Japan and Indonesia. There are 100–300 described species, with some controversy over the exact number.");
            put("anthurium", "Anthurium is a genus of about 1000 species of flowering plants, the largest genus of the arum family, Araceae. General common names include anthurium, tailflower, flamingo flower, and laceleaf.");
            put("iris", "Iris is a genus of 260–300 species of flowering plants with showy flowers. It takes its name from the Greek word for a rainbow, which is also the name for the Greek goddess of the rainbow, Iris. As well as being the scientific name, iris is also widely used as a common name for all Iris species, as well as some belonging to other closely related genera.");
            put("morning glory", "Morning glory (also written as morning-glory) is the common name for over 1,000 species of flowering plants in the family Convolvulaceae, whose current taxonomy and systematics are in flux.");
        }
    };

    public static final HashMap<String, String> FLOWER_BIOLOGY_URL = new HashMap<String, String>() {
        {
            put("rose", "https://www.biologyonline.com/search/rose/");
            put("lotus", "https://www.biologyonline.com/search/lotus/");
            put("daisy", "https://www.biologyonline.com/search/daisy/");
            put("sunflower", "https://www.biologyonline.com/search/sunflower/");
            put("common dandelion", "https://www.biologyonline.com/search/dandelion/");
            put("common tulip", "https://www.biologyonline.com/search/tulip/");
            put("camellia", "https://www.biologyonline.com/search/camellia/");
            put("anthurium", "https://www.biologyonline.com/search/anthurium/");
            put("iris", "https://www.biologyonline.com/search/iris/");
            put("morning glory", "https://www.biologyonline.com/search/morning+glory/");
        }
    };

    public static final HashMap<String, String> FLOWER_DEFINITION = new HashMap<String, String>() {
        {
            put("rose", "A flower and shrub of any species of the genus rosa, of which there are many species, mostly found in the northern hemisphere. Roses are shrubs with pinnate leaves and usually prickly stems.");
            put("lotus", "(Science: botany) a name of several kinds of water lilies; as Nelumbium speciosum, used in religious ceremonies, anciently in egypt, and to this day in Asia; Nelumbium luteum, the American lotus; and nymphaea lotus and N. Caerulea, the respectively white-flowered and blue-flowered lotus of modern egypt, which, with Nelumbium speciosum, are figured on its ancient monuments.");
            put("daisy", "(Science: botany) a genus of low herbs (Bellis), belonging to the family Compositae. The common english and classical daisy is B. Prennis, which has a yellow disk and white or pinkish rays. The whiteweed (Chrysanthemum Leucanthemum), the plant commonly called daisy in North America; called also oxeye daisy.");
            put("sunflower", "Any plant of the genus helianthus; so called probably from the form and colour of its flower, which is large disk with yellow rays. The commonly cultivated sunflower is Helianthus annuus, a native of America.");
            put("common dandelion", "(Science: botany) a well-known plant of the genus taraxacum (t. Officinale, formerly called t. Dens-leonis and Leontodos taraxacum) bearing large, yellow, compound flowers, and deeply notched leaves.");
            put("common tulip", "(Science: botany) Any plant of the liliaceous genus Tulipa. Many varieties are cultivated for their beautiful, often variegated flowers. Tulip tree. A large American tree bearing tuliplike flowers.");
            put("camellia", "Sorry, Biology Online does not have definition for this flower.");
            put("anthurium", "Anthurium is a genus of about 1000 species of flowering plants, the largest genus of the arum family, Araceae. General common names include anthurium, tailflower, flamingo flower, and laceleaf.");
            put("iris", "(Science: botany) a genus of plants having showy flowers and bulbous or tuberous roots, of which the flower-de-luce (fleur-de-lis), orris, and other species of flag are examples.");
            put("morning glory", "(Science: botany) A climbing plant (ipomoea purpurea) having handsome, funnel-shaped flowers, usually red, pink, purple, white, or variegated, sometimes pale blue.");
        }
    };
}
