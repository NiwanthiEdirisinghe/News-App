package com.example.newsapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment  extends Fragment {
    private RecyclerView topStoriesRecyclerView;
    private RecyclerView newsRecyclerView;
    private TopStoriesAdapter topStoriesAdapter;
    private NewsAdapter newsAdapter;
    private NewsItemClickListener newsItemClickListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof NewsItemClickListener) {
            newsItemClickListener = (NewsItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement NewsItemClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        topStoriesRecyclerView = view.findViewById(R.id.top_stories_recycler_view);
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        topStoriesAdapter = new TopStoriesAdapter(getTopStories(), newsItemClickListener);
        topStoriesRecyclerView.setAdapter(topStoriesAdapter);

        newsRecyclerView = view.findViewById(R.id.news_recycler_view);
        newsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        newsAdapter = new NewsAdapter(getNews(), newsItemClickListener);
        newsRecyclerView.setAdapter(newsAdapter);

        return view;
    }

    private List<NewsItem> getTopStories() {
        List<NewsItem> topStories = new ArrayList<>();

        topStories.add(new NewsItem("1", "Pastor Bajinder Singh Sentenced to Life Imprisonment", "Important breaking news story",
                "https://i0.wp.com/www.webpronews.com/wp-content/uploads/2025/04/2026-Subaru-Outback-and-Outback-Wilderness.jpg?fit=1221%2C469&ssl=1",
                "FOn April 1, 2025, a Mohali court sentenced self-proclaimed Christian pastor Bajinder Singh to life imprisonment for a 2018 rape case. The court observed that Singh misused his position as a preacher to commit a heinous crime against a woman, infringing upon her privacy and sanctity. The verdict was pronounced after Singh was held guilty on March 28, 2025", "Politics", "2023-10-12"));

        topStories.add(new NewsItem("2", "Google Faces Landmark Antitrust Trial Over Search Practices", "Latest in technology",
                "https://imageio.forbes.com/specials-images/imageserve/637b1d11729a96ce28ea598c/0x0.jpg?format=jpg&height=900&width=1600&fit=bounds",
                "The U.S. Department of Justice has initiated a remedy hearing against Google, accusing the tech giant of monopolistic practices in the search and digital advertising markets. The DOJ alleges that Google pays billions to be the default search engine, thereby stifling competition. Proposed remedies include the divestiture of Chrome and Android to dismantle Google's alleged monopoly. Google plans to appeal the decision, arguing that such measures would harm consumers and businesses.", "Technology", "2023-10-11"));

        topStories.add(new NewsItem("3", "Simone Biles and Mondo Duplantis Honored at 2025 Laureus Awards", "Recent sports events",
                "https://e0.365dm.com/25/04/768x432/skysports-forest-spurs-premier-league_6893427.png?20250421221917",
                "At the 25th Laureus World Sports Awards held in Madrid, gymnast Simone Biles was named Sportswoman of the Year, marking her fourth win in this category. Swedish pole vaulter Mondo Duplantis received the Sportsman of the Year award for his exceptional performances, including setting new world records. The event celebrated the achievements of athletes who have made significant contributions to their sports.", "Sports", "2023-10-10"));

        topStories.add(new NewsItem("4", "Health Alert", "Important health information",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkPMGz_83vSyBW02c4LY1MouTLcAtwD7IiIw5pUniCbU230Q3nCBuQemh07WrKN_v4HaY&usqp=CAU",
                "Full content here", "Health", "2023-10-09"));

        return topStories;
    }

    private List<NewsItem> getNews() {
        List<NewsItem> news = new ArrayList<>();

        news.add(new NewsItem("5", "Local News", "What's happening in your city",
                "https://live-production.wcms.abc-cdn.net.au/019db1787f723bcb2fbbd1f4a0f4e9c3?impolicy=wcms_crop_resize&cropH=2813&cropW=5000&xPos=0&yPos=260&width=862&height=485",
                "City officials unveiled a major urban renewal project this week aimed at revitalizing downtown neighborhoods. The $25 million plan includes the development of new green spaces, bike lanes, upgraded street lighting, and support for small businesses. According to Mayor Lisa Chen, the initiative is part of a long-term vision to create a safer, more vibrant city core that is walkable, sustainable, and inclusive.\\n\\nResidents will also benefit from improved public transit access and community centers that offer services for youth and seniors. Public forums are scheduled throughout the month to gather feedback, and construction is expected to begin early next year. City planners emphasized the importance of balancing modernization with the preservation of historical landmarks.", "Local", "2023-10-12"));
        news.add(new NewsItem("6", "Business Report", "Market updates and business news",
                "https://wbpgroup.com.au/wp-content/uploads/2024/05/shutterstock_2300256545-scaled.jpg",
                "Wall Street posted moderate gains this week as investors responded positively to third-quarter earnings reports from major tech and healthcare firms. The NASDAQ led the charge with a 2.1% increase, fueled by strong performance from AI and cloud service providers. Meanwhile, inflation continues to show signs of cooling, prompting speculation that the Federal Reserve may hold interest rates steady in its next meeting.\\n\\nGlobal markets mirrored the optimism, though economic uncertainty remains high in Europe due to rising energy costs. In the corporate world, mergers and acquisitions are on the rise again, particularly in the fintech sector. Analysts are urging caution as geopolitical tensions and volatile oil prices may still trigger market fluctuations.", "Business", "2023-10-11"));
        news.add(new NewsItem("7", "Entertainment", "Latest in entertainment",
                "https://media.licdn.com/dms/image/v2/C4E12AQH0nqdPDxOz7g/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1635189014664?e=2147483647&v=beta&t=LU49HKxWSBAY_ymrAwphWu9g4eNipyKeAapYsq6cCKc",
                "The entertainment industry is abuzz following the release of several critically acclaimed films at FilmFest 2023. Indie breakout 'The Last Ember' captured hearts with its raw storytelling, while big-budget entries like 'Celestial Drift' and 'The Forgotten Hour' brought stunning visuals and star-studded casts. Streaming platforms continued their dominance, with Netflix’s new true crime docuseries trending globally within hours of release.\\n\\nIn music, pop icon Aleya dropped her surprise album 'Midnight Thoughts', which shattered streaming records in just 24 hours. Broadway is also seeing a renaissance with a modern adaptation of 'Hamlet' drawing rave reviews. As the awards season looms, insiders predict a highly competitive year across film, television, and music.", "Entertainment", "2023-10-10"));
        news.add(new NewsItem("8", "Science Discovery", "New scientific breakthroughs",
                "https://images.theconversation.com/files/590453/original/file-20240129-25-l86tp9.jpg?ixlib=rb-4.1.0&rect=23%2C11%2C1973%2C1200&q=20&auto=format&w=320&fit=clip&dpr=2&usm=12&cs=strip",
                "In a major scientific breakthrough, researchers at the European Institute of Energy unveiled a solar-thermal battery capable of storing solar energy for up to 18 days. This new technology could solve one of renewable energy's biggest challenges—intermittency. The battery uses a compound that traps solar heat and releases it on demand through a chemical reaction, making it a game-changer for both domestic and industrial use.\\n\\nLead scientist Dr. Amir Khatib stated, “This innovation has the potential to fundamentally shift how we think about sustainable power storage.” The prototype is currently undergoing testing in real-world conditions in Spain and Morocco, with early results showing a 30% increase in efficiency compared to current lithium-ion technology.", "Science", "2023-10-09"));
        news.add(new NewsItem("9", "Tech Trends", "AI and innovation",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZh3ptZqn_5ZBN48Ogrn8gHc3sD2nXSj9jFky2WSUxJIziFNHdjswAG0uyk0dsiitKQFw&usqp=CAU",
                "Artificial Intelligence continues to lead the conversation in tech circles, with the latest generation of generative AI models demonstrating impressive capabilities in writing, coding, and image creation. Tech giants like Google, Meta, and OpenAI are racing to integrate AI into consumer products, from virtual assistants to intelligent photo editors.\n\nHowever, the rise of AI also brings ethical concerns. Governments and researchers are calling for clear guidelines to regulate its use, especially regarding data privacy, misinformation, and automation of jobs. Despite this, investment in AI startups has reached record highs, and industry analysts predict that AI will become a $1 trillion market within the next decade.",
                "Technology", "2023-10-08"));

        news.add(new NewsItem("10", "Health Update", "New vaccine shows promise",
                "https://san.com/wp-content/uploads/2025/02/CLEAN-CANCER-VACCINE_Getty-Images_featuredImage_Thu-Feb-20-2025.jpg?w=300",
                "Medical researchers have reported promising results from a new universal flu vaccine that could eliminate the need for annual shots. Developed using mRNA technology, the vaccine targets a broad range of influenza strains and has successfully passed Phase 2 clinical trials. Early findings show a 94% efficacy rate with minimal side effects.\n\nDr. Helena Suarez, lead researcher on the project, noted that if successful in Phase 3, the vaccine could be available to the public by 2026. Health experts say this breakthrough could revolutionize how we fight seasonal flu and prepare for future pandemics, especially in vulnerable populations like seniors and children.",
                "Health", "2023-10-07"));

        news.add(new NewsItem("11", "World Politics", "Global leaders meet for climate action",
                "https://global.unitednations.entermediadb.net/assets/mediadb/services/module/asset/downloads/preset/assets/2019/06/28-06-2019-G20-family-KS1_5435.jpg/image1170x530cropped.jpg",
                "Leaders from over 90 countries met this week at the Global Climate Action Summit in Geneva to accelerate progress toward carbon neutrality. The summit resulted in a landmark agreement committing developed nations to invest $200 billion in renewable energy initiatives across the Global South.\n\nThe summit also emphasized the need for climate adaptation measures, particularly for small island nations facing rising sea levels. While the tone was optimistic, climate activists expressed skepticism, pointing out that similar pledges in the past have fallen short. Still, environmental groups praised the push for accountability, with new mechanisms proposed for tracking carbon reduction commitments year by year.",
                "Politics", "2023-10-06"));

        news.add(new NewsItem("12", "Travel & Culture", "Hidden gems in Southeast Asia",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSC5ubXV4SNhEOooBO_2LD_RlYZxOi1AaxEe8XXlh2Gim8jox-mgsEEUII_7s3gdufUNr4&usqp=CAU",
                "Southeast Asia is emerging as a top destination for travelers looking to escape the crowds and explore hidden gems. From the karst islands of Ha Long Bay to the tranquil temples of Luang Prabang, the region offers rich history, vibrant cultures, and lush landscapes. Eco-tourism is thriving, with many resorts adopting sustainable practices that support local communities.\n\nThe surge in remote work has also led to a boom in digital nomad-friendly hubs like Bali, Da Nang, and Chiang Mai. Travelers are advised to explore beyond tourist hotspots to discover authentic food, artisan markets, and traditional festivals that showcase the region’s cultural depth.",
                "Travel", "2023-10-05"));

        return news;
    }
}
