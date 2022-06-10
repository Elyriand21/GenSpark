import React from "react"

export default function Bio() {
    return (
        <div className="bio">
            <img src="/images/bioimage.jpg" />
            <h3>Félix Banks</h3>
            <p>Félix Banks was born on February 18th, 1999 at Mission Hospital in Asheville, NC. He attended
                Clyde A. Erwin High School and graduated in 2017. He went on to pursue a Computer Science/Mathematics double major
                at Maryville College after high school. Félix
                moved back home to Asheville where he continued to pursue his dreams in music and programming. In April 2022, he
                was excited to be working at GenSpark to further his knowledge and skills in Full Stack Java Development. Félix hopes
                to eventually work on trajectory software for telecommunication satellites.
            </p>
            <div className="button-container">
                <a href="https://github.com/Elyriand21/GenSpark" target="_blank">
                    <div className="button1">
                        GitHub
                    </div>
                </a>
                <a href="https://www.linkedin.com/in/felix-b-6010a5bb/" target="_blank">
                    <div className="button2">
                        Linkedin
                    </div>
                </a>
            </div>

        </div>
    )
}