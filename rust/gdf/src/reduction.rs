pub struct Reduction {
    /// reductions are not defined at runtime... yet, so static str it is
    pub item: &'static str,
    pub amount_needed: usize,
    pub reduction_applied: usize,
}

impl Reduction {
    fn new(item: &'static str, amount: usize, reduction: usize) -> Self {
        Self {
            item,
            amount_needed: amount,
            reduction_applied: reduction,
        }
    }
}

pub fn get_reductions() -> Vec<Reduction> {
    let shop_reductions = [
        Reduction::new("Cerises", 2, 20),
        Reduction::new("Bananes", 2, 150),
        Reduction::new("Apples", 3, 100),
        Reduction::new("Mele", 2, 100),
    ];
    shop_reductions.into()
}
