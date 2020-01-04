using System;

namespace Question
{
    public class Draw : IComparable
    {
        public int Height { get; private set; }
        public int Width  { get; private set; }
        public int Surface { get { return this.Height * this.Width; } }

        public Draw(int height, int width)
        {
            this.Height = height;
            this.Width = width;
        }

        public bool IsOverlap(Draw carton)
        {
            return this.Height >= carton.Height && this.Width >= carton.Width;
        }

        public override bool Equals(object obj)
        {
            if (obj is Draw)
            {
                return (obj as Draw).Height == this.Height &&
                        (obj as Draw).Width == this.Width;
            }

            return base.Equals(obj);
        }

        public int CompareTo(object obj)
        {
            if (!(obj is Draw))
            {
                throw new ArgumentException("Cannot compare different object");
            }

            var drawing = obj as Draw;

            if (this.Height > drawing.Height || (this.Height == drawing.Height && this.Width > drawing.Width))
            {
                return 1;
            }

            if (this.Height == drawing.Height && this.Width == drawing.Width)
            {
                return 0;
            }

            return -1;
         }
    }
}
