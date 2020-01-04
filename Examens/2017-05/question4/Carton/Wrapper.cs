namespace Question
{
    public class Wrapper
    {
        public int Height { get; private set; }
        public int Width { get; private set; }
        public int Surface { get { return this.Height * this.Width; } }

        public Wrapper(int height, int width)
        {
            this.Height = height;
            this.Width = width;
        }

        public override bool Equals(object obj)
        {
            if (obj is Wrapper)
            {
                return (obj as Wrapper).Height == this.Height &&
                        (obj as Wrapper).Width == this.Width;
            }

            return base.Equals(obj);
        }
    }
}